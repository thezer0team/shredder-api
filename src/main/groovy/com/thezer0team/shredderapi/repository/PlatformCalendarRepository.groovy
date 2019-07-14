package com.thezer0team.shredderapi.repository

import com.thezer0team.shredderapi.model.PlatformCalendarEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PlatformCalendarRepository extends MongoRepository<PlatformCalendarEntity, String> {
}
