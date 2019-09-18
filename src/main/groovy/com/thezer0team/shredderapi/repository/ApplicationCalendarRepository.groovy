package com.thezer0team.shredderapi.repository

import com.thezer0team.shredderapi.model.ApplicationCalendarEntity
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
@EnableScan
interface ApplicationCalendarRepository extends CrudRepository<ApplicationCalendarEntity, String> {

}
