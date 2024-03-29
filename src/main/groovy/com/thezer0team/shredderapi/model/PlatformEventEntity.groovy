package com.thezer0team.shredderapi.model

import com.google.cloud.Timestamp
import com.google.cloud.datastore.Key
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity
import org.springframework.cloud.gcp.data.datastore.core.mapping.Field
import org.springframework.data.annotation.Id



@Entity(name = 'platform_events')
class PlatformEventEntity {

    @Id
    @Field(name = 'platform_event_id')
    Key platformEventId

    String name

    String description

    Timestamp startTime

    Timestamp endTime

    //TODO research location objects
    String location

}
