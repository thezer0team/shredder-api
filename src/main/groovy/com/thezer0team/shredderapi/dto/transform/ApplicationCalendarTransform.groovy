package com.thezer0team.shredderapi.dto.transform

import com.thezer0team.shredderapi.dto.response.ApplicationCalendarResponse
import com.thezer0team.shredderapi.model.ApplicationCalendarEntity
import org.springframework.stereotype.Component

@Component
class ApplicationCalendarTransform {

    ApplicationCalendarResponse getResponseFromEntity(ApplicationCalendarEntity applicationCalendarEntity) {

        return new ApplicationCalendarResponse(
                calendarId: applicationCalendarEntity.applicationCalendarId,
                user: applicationCalendarEntity.user,
                applicationCalendarEvent: applicationCalendarEntity.events
        )
    }
}
