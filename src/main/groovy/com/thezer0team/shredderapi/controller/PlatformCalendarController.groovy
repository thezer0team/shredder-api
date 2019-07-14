package com.thezer0team.shredderapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("calendar/")
class PlatformCalendarController {

    @RequestMapping(value = 'status', method = RequestMethod.GET)
    String getRetailProduct(){

        return 'Tonight I dine on turtle soup.'
    }
}
