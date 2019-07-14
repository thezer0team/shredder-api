package com.thezer0team.shredderapi.dto.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.thezer0team.shredderapi.model.ApplicationCalendarEventEntity
import com.thezer0team.shredderapi.model.UserEntity
import groovy.transform.Canonical

@Canonical
@JsonIgnoreProperties(ignoreUnknown = true)
class ApplicationCalendarResponse {

    @JsonProperty('calendar_id')
    String calendarId

    @JsonProperty('user_id')
    UserEntity user

    @JsonProperty('events')
    Set<ApplicationCalendarEventEntity> applicationCalendarEvent

}
