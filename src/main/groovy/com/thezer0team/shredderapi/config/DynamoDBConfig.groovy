package com.thezer0team.shredderapi.config

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig
import com.thezer0team.shredderapi.repository.ApplicationCalendarRepository
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.socialsignin.spring.data.dynamodb.mapping.DynamoDBMappingContext
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import com.thezer0team.shredderapi.repository.PlatformCalendarRepository
import com.thezer0team.shredderapi.repository.UserRepository
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
@EnableAutoConfiguration(exclude = [DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class])
@EnableDynamoDBRepositories(basePackageClasses =  [ApplicationCalendarRepository.class, PlatformCalendarRepository.class, UserRepository.class])
@EntityScan(basePackages = 'com.thezer0team.shredderapi.*.*')
class DynamoDBConfig {

    @Value('${amazon.dynamodb.accesskey}')
    private String amazonDynamoDBAccessKey

    @Value('${amazon.dynamodb.secretkey}')
    private String amazonDynamoDBSecretKey

    AWSCredentialsProvider amazonAWSCredentialsProvider() {
        return new AWSStaticCredentialsProvider(amazonAWSCredentials())
    }

    @Bean
    AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonDynamoDBAccessKey, amazonDynamoDBSecretKey)
    }

    @Bean
    DynamoDBMapperConfig dynamoDBMapperConfig() {
        return DynamoDBMapperConfig.DEFAULT
    }

    @Bean
    @Primary
    DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig config) {
        return new DynamoDBMapper(amazonDynamoDB, config)
    }

    @Bean
    AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider())
                .withRegion(Regions.US_EAST_1).build()
    }

    @Bean
    DynamoDBMappingContext dynamoDBMappingContext() {
        return new DynamoDBMappingContext()
    }
}

