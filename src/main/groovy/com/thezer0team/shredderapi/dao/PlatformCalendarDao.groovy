package com.thezer0team.shredderapi.dao

import com.thezer0team.shredderapi.model.PlatformCalendarEntity
import com.thezer0team.shredderapi.repository.PlatformCalendarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PlatformCalendarDao {

    @Autowired
    PlatformCalendarRepository platformCalendarRepository

    PlatformCalendarEntity createNewPlatformCalendar(PlatformCalendarEntity platformCalendarEntity) {
        return platformCalendarRepository.save(platformCalendarEntity)
    }
}
