package com.thezer0team.shredderapi.model

import org.springframework.cloud.gcp.data.datastore.core.mapping.Descendants
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity
import org.springframework.cloud.gcp.data.datastore.core.mapping.Field
import org.springframework.cloud.gcp.data.datastore.core.mapping.Reference

import javax.persistence.Id

@Entity(name = "users")
class UserEntity {

    @Id
    @Field(name = "user_id")
    String userId

    @Field(name = 'user_name')
    String userName

    @Field(name = 'user_email')
    String userEmail

    @Reference
    ApplicationCalendarEntity applicationCalendar
}
