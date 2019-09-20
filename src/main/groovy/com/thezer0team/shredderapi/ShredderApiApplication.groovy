package com.thezer0team.shredderapi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Configuration

@Configuration
@SpringBootApplication
class ShredderApiApplication {

	static void main(String[] args) {
		SpringApplication.run(ShredderApiApplication, args)
	}

}
