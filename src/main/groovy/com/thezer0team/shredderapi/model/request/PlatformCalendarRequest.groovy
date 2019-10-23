package com.thezer0team.shredderapi.model.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Canonical

@Canonical
@JsonIgnoreProperties(ignoreUnknown = true)
class PlatformCalendarRequest {

    @JsonProperty('url_safe_key')
    String urlSafeKey

    @JsonProperty('source_type')
    String sourceType

    @JsonProperty('application_calendar_id')
    BigInteger applicationCalendarId

    @JsonProperty('name')
    String name

    @JsonProperty('calendar_events')
    List<PlatformEventRequest> platformEvents
}
