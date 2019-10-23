package com.thezer0team.shredderapi.controller


import com.thezer0team.shredderapi.model.UserEntity
import com.thezer0team.shredderapi.model.request.UserRequest
import com.thezer0team.shredderapi.model.response.UserResponse
import com.thezer0team.shredderapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

@RestController
@RequestMapping(value = 'user')
class UserController {

    @Autowired
    UserService userService

    @PostMapping(value = 'create')
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<UserResponse> createNewUser(@RequestBody @Valid UserRequest userRequest ) {

        UserEntity userEntity = userService.createUser(userRequest)

        UserResponse response = userService.getResponseFromEntity(userEntity)

        return new ResponseEntity(response, HttpStatus.CREATED)
    }

    @GetMapping(value = 'accounts')
    List<String> getAllUserAccounts() {

        return userService.getAllAccounts()
    }

    @PostMapping(value = 'find')
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    ResponseEntity<UserResponse> getUser(@RequestBody @Valid UserRequest userRequest) {

        UserEntity userEntity = userService.getUser(userRequest)

        UserResponse response = userService.getResponseFromEntity(userEntity)

        return new ResponseEntity(response, HttpStatus.CREATED)    }
}
