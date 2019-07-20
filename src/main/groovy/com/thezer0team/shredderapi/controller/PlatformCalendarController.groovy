package com.thezer0team.shredderapi.controller

import com.thezer0team.shredderapi.dto.request.PlatformCalendarRequest
import com.thezer0team.shredderapi.dto.response.ApplicationCalendarResponse
import com.thezer0team.shredderapi.dto.response.PlatformCalendarResponse
import com.thezer0team.shredderapi.model.ApplicationCalendarEntity
import com.thezer0team.shredderapi.model.PlatformCalendarEntity
import com.thezer0team.shredderapi.service.CalendarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("calendar/")
class PlatformCalendarController {

    @Autowired
    CalendarService calendarService


    @PostMapping(value = '', produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<ApplicationCalendarResponse> createNewCalendar(@RequestBody @Valid PlatformCalendarRequest platformCalendarRequest) {

        ApplicationCalendarEntity applicationCalendarEntity = calendarService.assignNewPlatformToCalendar(platformCalendarRequest)

        ApplicationCalendarResponse applicationCalendarResponse = calendarService.getApplicationCalendarResponseFromEntity(applicationCalendarEntity)

        return new ResponseEntity(applicationCalendarResponse, HttpStatus.CREATED)
    }

    @PutMapping(value = 'create', produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<PlatformCalendarResponse> createPlatformCalendar(@RequestParam(name = 'platform') String platform,
            @RequestBody @Valid PlatformCalendarRequest platformCalendarRequest) {

        //TODO if platform != [gmail,ical,outlook,facebook] throw err

        PlatformCalendarEntity platformCalendarEntity = calendarService.createPlatformCalendar(platformCalendarRequest)

        PlatformCalendarResponse platformCalendarResponse = calendarService.getPlatformCalendarResponseFromEntity(platformCalendarEntity)

        return  new ResponseEntity(platformCalendarResponse, HttpStatus.CREATED)
    }
}
