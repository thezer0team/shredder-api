package com.thezer0team.shredderapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

@Configuration
class AppConfig {

    @Bean
    ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator())
    }

    @Bean
    LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean()
    }
}
