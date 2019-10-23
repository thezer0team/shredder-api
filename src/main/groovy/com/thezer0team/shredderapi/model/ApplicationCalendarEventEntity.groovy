package com.thezer0team.shredderapi.model

import com.google.cloud.Timestamp
import com.google.cloud.datastore.Key
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity
import org.springframework.cloud.gcp.data.datastore.core.mapping.Field
import org.springframework.data.annotation.Id


@Entity(name = 'application_calendar_events')
class ApplicationCalendarEventEntity {

    @Id
    @Field(name = 'event_id')
    Key eventId

    String platformEventId

    String name

    String description

    Timestamp startTime

    Timestamp endTime

    //TODO research location objects
    String location

}
