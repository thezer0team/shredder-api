package com.thezer0team.shredderapi.controller

import com.thezer0team.shredderapi.dto.request.PlatformCalendarRequest
import com.thezer0team.shredderapi.dto.response.ApplicationCalendarResponse
import com.thezer0team.shredderapi.model.ApplicationCalendarEntity
import com.thezer0team.shredderapi.service.CalendarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

@RestController
@RequestMapping("calendar/")
class PlatformCalendarController {

    @Autowired
    CalendarService calendarService

    @RequestMapping(value = 'status', method = RequestMethod.GET)
    String getRetailProduct() {

        return 'Tonight I dine on turtle soup.'
    }


    @PostMapping(value = '', produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<ApplicationCalendarResponse> createNewCalendar(@RequestBody @Valid PlatformCalendarRequest platformCalendarRequest) {

        ApplicationCalendarEntity applicationCalendarEntity = calendarService.assignNewPlatformToCalendar(platformCalendarRequest)

        ApplicationCalendarResponse applicationCalendarResponse = calendarService.getResponseFromEntity(applicationCalendarEntity)

        return new ResponseEntity(applicationCalendarResponse, HttpStatus.CREATED)
    }
}
