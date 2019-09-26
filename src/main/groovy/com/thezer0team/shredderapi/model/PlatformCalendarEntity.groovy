package com.thezer0team.shredderapi.model

import com.google.common.collect.ImmutableSet
import org.springframework.cloud.gcp.data.datastore.core.mapping.Descendants
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity
import org.springframework.cloud.gcp.data.datastore.core.mapping.Field
import org.springframework.data.annotation.Id


@Entity(name = 'platform_calendars')
class PlatformCalendarEntity {

    @Id
    @Field(name = 'platform_calendar_id')
    String platformCalendarId

    @Field(name = 'platform_calendar_name')
    String platformCalendarName

    @Field(name = 'platform_name')
    String platformName

    @Field(name = 'source_type')
    String sourceType

    @Descendants
    ImmutableSet<PlatformEventEntity> events

}
