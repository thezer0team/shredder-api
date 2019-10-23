package com.thezer0team.shredderapi.model.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Canonical

@Canonical
@JsonIgnoreProperties(ignoreUnknown = true)
class PlatformCalendarResponse {

    @JsonProperty('platform')
    String platform

    @JsonProperty('calendar_name')
    String calendarName

    @JsonProperty('number_of_events')
    int numberOfEvents
}
