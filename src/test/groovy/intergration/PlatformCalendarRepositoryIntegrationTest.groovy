package intergration

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException
import com.thezer0team.shredderapi.model.PlatformCalendarEntity
import com.thezer0team.shredderapi.model.PlatformEventEntity
import com.thezer0team.shredderapi.repository.PlatformCalendarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification

import java.time.Instant

@ActiveProfiles("local")
@TestPropertySource(properties = [
        'amazon.dynamodb.endpoint=http://localhost:8000/',
        'amazon.aws.accesskey=test1',
        'amazon.aws.secretkey=test231'])
class PlatformCalendarRepositoryIntegrationTest extends Specification{

    DynamoDBMapper dynamoDBMapper

    @Autowired
    AmazonDynamoDB amazonDynamoDB

    @Autowired
    PlatformCalendarRepository platformCalendarIRepository;

    def setup() {
        try {
            amazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
                    new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
                    .build()

            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB)

            CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(PlatformCalendarEntity.class)
            tableRequest.setProvisionedThroughput(
                    new ProvisionedThroughput(1L, 1L))

            amazonDynamoDB.createTable(tableRequest)
        } catch (ResourceInUseException  e) {

        }

    }

    def cleanup() {
        dynamoDBMapper.batchDelete((List<PlatformCalendarEntity>) platformCalendarIRepository.findAll())
    }

    def 'happy - save and get platform calendar'() {
        given:
        PlatformCalendarEntity platformCalendarSample = new PlatformCalendarEntity(
                sourceType: 'TestSource',
                applicationCalendarId: 1234,
                name: 'Sample Calendar',
                events: [
                        new PlatformEventEntity(
                                name: 'Event 1',
                                description: 'This is the first event',
                                startTime: Instant.parse('2007-12-03T10:15:30.00Z'),
                                endTime: Instant.parse('2007-12-03T12:15:30.00Z'),
                                location: 'Just some place'
                        ),
                        new PlatformEventEntity(
                                name: 'Event 2',
                                description: 'This is the second event',
                                startTime: Instant.parse('2007-12-10T01:15:30.00Z'),
                                endTime: Instant.parse('2007-12-10T09:15:30.00Z'),
                                location: 'Just some place'
                        )
                ]
        )

        when:
        platformCalendarIRepository.save(platformCalendarSample)

        and:
        List<PlatformCalendarEntity> result = (List<PlatformCalendarEntity>) platformCalendarIRepository.findAll()

        then:
        result.size() > 0
        result.get(0) == platformCalendarSample
    }
}
