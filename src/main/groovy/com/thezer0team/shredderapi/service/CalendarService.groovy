package com.thezer0team.shredderapi.service

import com.thezer0team.shredderapi.dao.ApplicationCalendarDao
import com.thezer0team.shredderapi.dao.PlatformCalendarDao
import com.thezer0team.shredderapi.dao.UserDao
import com.thezer0team.shredderapi.dto.request.PlatformCalendarRequest
import com.thezer0team.shredderapi.dto.response.ApplicationCalendarResponse
import com.thezer0team.shredderapi.dto.transform.ApplicationCalendarTransform
import com.thezer0team.shredderapi.dto.transform.PlatformCalendarTransform
import com.thezer0team.shredderapi.model.ApplicationCalendarEntity
import com.thezer0team.shredderapi.model.PlatformCalendarEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CalendarService {

    @Autowired
    PlatformCalendarTransform platformCalendarTransform

    @Autowired
    ApplicationCalendarTransform applicationCalendarTransform

    @Autowired
    ApplicationCalendarDao applicationCalendarDao

    @Autowired
    PlatformCalendarDao platformCalendarDao

    @Autowired
    UserDao userDao

    ApplicationCalendarEntity assignNewPlatformToCalendar(PlatformCalendarRequest platformCalendarRequest) {

        PlatformCalendarEntity platformCalendarEntity = platformCalendarTransform.getEntityFromRequest(platformCalendarRequest)

        platformCalendarDao.createNewPlatformCalendar(platformCalendarEntity)

        return applicationCalendarDao.readApplicationCalendarById(platformCalendarRequest.applicationCalendarId.toString())
    }

    ApplicationCalendarResponse getResponseFromEntity(ApplicationCalendarEntity applicationCalendarEntity) {


        return applicationCalendarTransform.getResponseFromEntity(applicationCalendarEntity)
    }
}
