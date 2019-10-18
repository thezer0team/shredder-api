package com.thezer0team.shredderapi.dto.transform

import com.thezer0team.shredderapi.dto.request.PlatformCalendarRequest
import com.thezer0team.shredderapi.dto.response.PlatformCalendarResponse
import com.thezer0team.shredderapi.model.PlatformCalendarEntity
import com.thezer0team.shredderapi.model.PlatformEventEntity
import org.springframework.stereotype.Component
import com.google.cloud.Timestamp


@Component
class PlatformCalendarTransform {

    static PlatformCalendarEntity getEntityFromRequest(PlatformCalendarRequest platformCalendarRequest) {

        return new PlatformCalendarEntity(
                sourceType: platformCalendarRequest.sourceType,
                platformCalendarId: platformCalendarRequest.applicationCalendarId,
                platformCalendarName: platformCalendarRequest.name,
                events: platformCalendarRequest.platformEvents.collect { requestEvent ->
                    new PlatformEventEntity(
                            name: requestEvent.name,
                            description: requestEvent.description,
                            startTime: Timestamp.parseTimestamp(requestEvent.startTime),
                            endTime: Timestamp.parseTimestamp(requestEvent.endTime),
                            location: requestEvent.location
                    )
                }
        )
    }


    static PlatformCalendarResponse getResponseFromEntity(PlatformCalendarEntity platformCalendarEntity) {

        return new PlatformCalendarResponse(
                platform: platformCalendarEntity.sourceType,
                calendarName: platformCalendarEntity.platformCalendarName,
                numberOfEvents: platformCalendarEntity.events.size()
        )
    }
}

