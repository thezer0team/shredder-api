package com.thezer0team.shredderapi.dto.transform

import com.thezer0team.shredderapi.dto.request.PlatformCalendarRequest
import com.thezer0team.shredderapi.model.PlatformCalendarEntity
import org.springframework.stereotype.Component

@Component
class PlatformCalendarTransform {

    PlatformCalendarEntity getEntityFromRequest(PlatformCalendarRequest platformCalendarRequest) {

        return new PlatformCalendarEntity(
                sourceType: platformCalendarRequest.sourceType,
                applicationCalendarId: platformCalendarRequest.applicationCalendarId,
                name: platformCalendarRequest.name
        )
    }
}

