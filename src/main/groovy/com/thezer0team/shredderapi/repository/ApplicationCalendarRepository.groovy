package com.thezer0team.shredderapi.repository

import com.thezer0team.shredderapi.model.ApplicationCalendarEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ApplicationCalendarRepository extends MongoRepository<ApplicationCalendarEntity, String> {
}
