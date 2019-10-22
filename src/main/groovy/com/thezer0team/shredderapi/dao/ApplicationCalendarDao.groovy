package com.thezer0team.shredderapi.dao

import com.thezer0team.shredderapi.model.ApplicationCalendarEntity
import com.thezer0team.shredderapi.repository.ApplicationCalendarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
class ApplicationCalendarDao {

    @Autowired
    ApplicationCalendarRepository applicationCalendarRepository

    ApplicationCalendarEntity createNewApplicationCalendar(ApplicationCalendarEntity applicationCalendarEntity) {
        return applicationCalendarRepository.save(applicationCalendarEntity)
    }

    ApplicationCalendarEntity readApplicationCalendarById(String id) {
        return applicationCalendarRepository.findById(id).get()
    }
}
