package com.thezer0team.shredderapi.repository

import com.thezer0team.shredderapi.model.PlatformCalendarEntity
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository

interface PlatformCalendarRepository extends DatastoreRepository<PlatformCalendarEntity, String> {
}
