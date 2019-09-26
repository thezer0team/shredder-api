package com.thezer0team.shredderapi.dto.transform

import com.thezer0team.shredderapi.dto.request.PlatformCalendarRequest
import com.thezer0team.shredderapi.dto.response.PlatformCalendarResponse
import com.thezer0team.shredderapi.model.PlatformCalendarEntity
import com.thezer0team.shredderapi.model.PlatformEventEntity
import org.springframework.stereotype.Component


@Component
class PlatformCalendarTransform {

    PlatformCalendarEntity getEntityFromRequest(PlatformCalendarRequest platformCalendarRequest) {

        return new PlatformCalendarEntity(
                sourceType: platformCalendarRequest.sourceType,
                applicationCalendarId: platformCalendarRequest.applicationCalendarId,
                name: platformCalendarRequest.name,
                events: platformCalendarRequest.platformEvents.collect { requestEvent ->
                    new PlatformEventEntity(
                            name: requestEvent.name,
                            description: requestEvent.description,
                            startTime: Timestamp.parse(requestEvent.startTime),
                            endTime: Timestamp.parse(requestEvent.endTime),
                            location: requestEvent.location
                    )
                }
        )
    }



    PlatformCalendarResponse getResponseFromEntity(PlatformCalendarEntity platformCalendarEntity) {

        return new PlatformCalendarResponse(
                platform: platformCalendarEntity.sourceType,
                calendarName: platformCalendarEntity.name,
                numberOfEvents: platformCalendarEntity.events.size()
        )
    }
}

