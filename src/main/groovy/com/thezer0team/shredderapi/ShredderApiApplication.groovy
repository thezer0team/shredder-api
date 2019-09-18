package com.thezer0team.shredderapi

import com.thezer0team.shredderapi.config.DynamoDBConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
//@Import([DynamoDBConfig.class])
@SpringBootApplication
class ShredderApiApplication {

	static void main(String[] args) {
		SpringApplication.run(ShredderApiApplication, args)
	}

}
