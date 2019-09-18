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
import com.amazonaws.services.dynamodbv2.document.DynamoDB
import com.thezer0team.shredderapi.repository.ApplicationCalendarRepository
import com.thezer0team.shredderapi.repository.PlatformCalendarRepository
import com.thezer0team.shredderapi.repository.UserRepository
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableDynamoDBRepositories(basePackageClasses = [PlatformCalendarRepository.class, ApplicationCalendarRepository.class, UserRepository.class])
@EntityScan(basePackages = 'com.thezer0team.shredderapi.*.*')
class DynamoDBConfig {

    @Value('${amazon.dynamodb.accesskey}')
    private String amazonDynamoDBAccessKey

    @Value('${amazon.dynamodb.secretkey}')
    private String amazonDynamoDBSecretKey

    @Bean
    AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonDynamoDBAccessKey, amazonDynamoDBSecretKey)
    }

    @Bean
    DynamoDBMapperConfig dynamoDBMapperConfig() {
        return DynamoDBMapperConfig.DEFAULT
    }

    @Bean
    DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig config) {
        return new DynamoDBMapper(amazonDynamoDB, config)
    }

    @Bean
    AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(amazonAWSCredentialsProvider())
                .withRegion(Regions.US_EAST_2)
                .build()
    }

    @Bean
    DynamoDB dynamoDB() {
        return new DynamoDB(amazonDynamoDB())
    }

    AWSCredentialsProvider amazonAWSCredentialsProvider() {
        return new AWSStaticCredentialsProvider(amazonAWSCredentials())
    }
}

