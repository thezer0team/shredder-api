package com.thezer0team.shredderapi.model

import com.google.cloud.datastore.Key
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity
import org.springframework.cloud.gcp.data.datastore.core.mapping.Field
import org.springframework.cloud.gcp.data.datastore.core.mapping.Reference
import org.springframework.data.annotation.Id


@Entity(name = "users")
class UserEntity {

    @Id
    @Field(name = "user_id")
    Key userId

    @Field(name = 'user_name')
    String userName

    @Field(name = 'user_email')
    String userEmail

    @Reference
    ApplicationCalendarEntity applicationCalendar
}
