package com.thezer0team.shredderapi.config

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.thezer0team.shredderapi.repository.PlatformCalendarRepository
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.StringUtils

@Configuration
@EnableDynamoDBRepositories(basePackageClasses = PlatformCalendarRepository.class)
class DynamoDBConfig {

    @Value('${amazon.dynamodb.endpoint}')
    private String amazonDynamoDBEndpoint

    @Value('${amazon.aws.accesskey}')
    private String amazonAWSAccessKey

    @Value('${amazon.aws.secretkey}')
    private String amazonAWSSecretKey

    @Bean
    AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials())

        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint)
        }

        return amazonDynamoDB
    }

    @Bean
    AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(
                amazonAWSAccessKey, amazonAWSSecretKey)
    }
}

