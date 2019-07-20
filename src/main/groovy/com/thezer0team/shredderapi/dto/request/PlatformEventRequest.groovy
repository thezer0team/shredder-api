package com.thezer0team.shredderapi.dto.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Canonical

import java.time.Instant

@Canonical
@JsonIgnoreProperties(ignoreUnknown = true)
class PlatformEventRequest {

    @JsonProperty('name')
    String name

    @JsonProperty('description')
    String description

    @JsonProperty('start_time')
    String startTime

    @JsonProperty('end_time')
    String endTime

    @JsonProperty('location')//TODO research location objects
    String location

}
