package com.thezer0team.shredderapi.model

import com.google.common.collect.ImmutableSet
import org.springframework.cloud.gcp.data.datastore.core.mapping.Descendants
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity
import org.springframework.cloud.gcp.data.datastore.core.mapping.Field
import org.springframework.cloud.gcp.data.datastore.core.mapping.Reference
import org.springframework.data.annotation.Id


@Entity(name = 'application_calendars')
class ApplicationCalendarEntity {

    @Id
    @Field(name = 'application_calendar_id')
    Long applicationCalendarId

    @Field(name = 'application_calendar_name')
    String name

    @Reference
    ImmutableSet<PlatformCalendarEntity> platformCalendars

    @Descendants
    ImmutableSet<ApplicationCalendarEventEntity> events

}
