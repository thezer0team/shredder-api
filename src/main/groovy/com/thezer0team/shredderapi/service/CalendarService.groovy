package com.thezer0team.shredderapi.service

import com.google.common.collect.ImmutableSet
import com.thezer0team.shredderapi.dao.PlatformCalendarDao
import com.thezer0team.shredderapi.dao.UserDao
import com.thezer0team.shredderapi.dto.transform.ApplicationCalendarTransform
import com.thezer0team.shredderapi.dto.transform.PlatformCalendarTransform
import com.thezer0team.shredderapi.model.ApplicationCalendarEntity
import com.thezer0team.shredderapi.model.PlatformCalendarEntity
import com.thezer0team.shredderapi.model.UserEntity
import com.thezer0team.shredderapi.model.request.PlatformCalendarRequest
import com.thezer0team.shredderapi.model.response.ApplicationCalendarResponse
import com.thezer0team.shredderapi.model.response.PlatformCalendarResponse
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.stereotype.Service

@Slf4j
@Service
class CalendarService {

    @Autowired
    PlatformCalendarTransform platformCalendarTransform

    @Autowired
    ApplicationCalendarTransform applicationCalendarTransform

    @Autowired
    PlatformCalendarDao platformCalendarDao

    @Autowired
    UserDao userDao

    /**
     * Create a new application calendar for a existing user.
     * Get existing user
     * Create new ApplicationCalendarEntity and assign to UserEntity
     * Create new PlatformCalendarEntity from PlatformCalendarRequest and assign to ApplicationCalendarEntity
     * Persist PlatformCalendarEntity and ApplicationCalendarEntity
     *
     * @param platformCalendarRequest receives new platform calendar request with user email
     * @return applicationCalendarEntity
     * */
    UserEntity assignNewPlatformToCalendar(String calendarName, PlatformCalendarRequest platformCalendarRequest) {

        UserEntity userAccount = userDao.readUserById(platformCalendarRequest.userId)

        if (!userAccount) {
            log.warn("Unable to locate user ${platformCalendarRequest.userId}", new ResourceNotFoundException("UserEntity ${platformCalendarRequest.userId}"))
        }

        PlatformCalendarEntity newPlatformCalendar = platformCalendarTransform.getEntityFromRequest(platformCalendarRequest)

        platformCalendarDao.createNewPlatformCalendar(newPlatformCalendar)

        ImmutableSet<PlatformCalendarEntity> platformCalendarEntities = []

        userAccount.applicationCalendar = new ApplicationCalendarEntity(
                name: calendarName,
                platformCalendars: platformCalendarEntities.of(newPlatformCalendar),
                events: ApplicationCalendarTransform.getEventsFromPlatform(newPlatformCalendar.events)
        )

        userDao.updateUser(userAccount)

        return userDao.readUserById(userAccount.userId)
    }

    ApplicationCalendarResponse getApplicationCalendarResponseFromUserEntity(UserEntity userEntity) {

        

        return applicationCalendarTransform.getResponseFromEntity(applicationCalendarEntity)
    }

    PlatformCalendarEntity createPlatformCalendar(PlatformCalendarRequest platformCalendarRequest) {

        return platformCalendarTransform.getEntityFromRequest(platformCalendarRequest)
    }

    PlatformCalendarResponse getPlatformCalendarResponseFromEntity(PlatformCalendarEntity platformCalendarEntity) {

        return platformCalendarTransform.getResponseFromEntity(platformCalendarEntity)
    }
}
