package com.thezer0team.shredderapi.dto.transform

import com.google.common.collect.ImmutableSet
import com.thezer0team.shredderapi.model.ApplicationCalendarEntity
import com.thezer0team.shredderapi.model.ApplicationCalendarEventEntity
import com.thezer0team.shredderapi.model.PlatformEventEntity
import com.thezer0team.shredderapi.model.response.ApplicationCalendarResponse
import org.springframework.stereotype.Component

@Component
class ApplicationCalendarTransform {

    /**
     * Iterate through platformCalendarEventEntities and copy list to immutableSet
     *
     * @param platformEventEntities
     * @return ApplicationCalendarEventEntity ImmutableSet<E>
     * */
    static ImmutableSet<ApplicationCalendarEventEntity> getEventsFromPlatform(ImmutableSet<PlatformEventEntity> platformEventEntities) {

        ImmutableSet<ApplicationCalendarEventEntity> applicationCalendarEventEntities = []

        return applicationCalendarEventEntities.copyOf(platformEventEntities.collect() { platformEvent ->
            new ApplicationCalendarEventEntity(
                    platformEventId: platformEvent.platformEventId,
                    name: platformEvent.name,
                    description: platformEvent.description,
                    startTime: platformEvent.startTime,
                    endTime: platformEvent.endTime,
            )}
        )
    }

    static ApplicationCalendarResponse getResponseFromEntity(ApplicationCalendarEntity applicationCalendarEntity) {

        return new ApplicationCalendarResponse(
                calendarId: applicationCalendarEntity.applicationCalendarId,
                applicationCalendarEvent: applicationCalendarEntity.events
        )
    }
}
