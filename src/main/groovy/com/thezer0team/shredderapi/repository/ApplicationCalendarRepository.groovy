package com.thezer0team.shredderapi.repository

import com.thezer0team.shredderapi.model.ApplicationCalendarEntity
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository


interface ApplicationCalendarRepository extends DatastoreRepository<ApplicationCalendarEntity, String> {
}
