package com.thezer0team.shredderapi.repository

import com.thezer0team.shredderapi.model.PlatformCalendarEntity
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
@EnableScan
interface PlatformCalendarRepository extends CrudRepository<PlatformCalendarEntity, String> {
}
