package com.thezer0team.shredderapi.controller


import com.thezer0team.shredderapi.model.PlatformCalendarEntity
import com.thezer0team.shredderapi.model.UserEntity
import com.thezer0team.shredderapi.model.request.PlatformCalendarRequest
import com.thezer0team.shredderapi.model.response.ApplicationCalendarResponse
import com.thezer0team.shredderapi.model.response.PlatformCalendarResponse
import com.thezer0team.shredderapi.service.CalendarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("calendar/")
class CalendarController {

    @Autowired
    CalendarService calendarService


    @PostMapping(value = 'application/create', produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<ApplicationCalendarResponse> createNewCalendar(@RequestParam(name = 'calendar_name') String calendarName, @RequestBody @Valid PlatformCalendarRequest platformCalendarRequest) {

        UserEntity user = calendarService.assignNewPlatformToCalendar(calendarName, platformCalendarRequest)

        ApplicationCalendarResponse applicationCalendarResponse = calendarService.getApplicationCalendarResponseFromUserEntity(user)

        return new ResponseEntity(applicationCalendarResponse, HttpStatus.CREATED)
    }

    @PostMapping(value = 'platform/create/{platform}', produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<PlatformCalendarResponse> createPlatformCalendar(@RequestParam(name = 'platform') String platform,
                                                                    @RequestBody @Valid PlatformCalendarRequest platformCalendarRequest) {

        //TODO if platform != [gmail,ical,outlook,facebook] throw err

        PlatformCalendarEntity platformCalendarEntity = calendarService.createPlatformCalendar(platformCalendarRequest)

        PlatformCalendarResponse platformCalendarResponse = calendarService.getPlatformCalendarResponseFromEntity(platformCalendarEntity)

        return  new ResponseEntity(platformCalendarResponse, HttpStatus.CREATED)
    }


}
