package com.thezer0team.shredderapi.dao

import com.thezer0team.shredderapi.model.PlatformCalendarEntity
import com.thezer0team.shredderapi.repository.PlatformCalendarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class PlatformCalendarDao {

    @Autowired
    PlatformCalendarRepository platformCalendarRepository

    @Transactional
    PlatformCalendarEntity createNewPlatformCalendar(PlatformCalendarEntity platformCalendarEntity) {
        return platformCalendarRepository.save(platformCalendarEntity)
    }
}
