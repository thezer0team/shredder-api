package com.thezer0team.shredderapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('')
class ApplcationController {

    @RequestMapping(value = 'shredder', method = RequestMethod.GET)
    ResponseEntity<String> getRetailProduct() {
        return ResponseEntity.ok('Tonight I dine on turtle soup.')
    }

    @RequestMapping(value = '', method = RequestMethod.GET)
    ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok('There will be no mistake this time. I go myself.')
    }
}
