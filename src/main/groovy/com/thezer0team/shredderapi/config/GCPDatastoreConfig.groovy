package com.thezer0team.shredderapi.config

import org.springframework.cloud.gcp.data.datastore.core.DatastoreTransactionManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
class GCPDatastoreConfig {


}
