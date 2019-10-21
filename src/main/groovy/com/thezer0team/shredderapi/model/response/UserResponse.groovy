package com.thezer0team.shredderapi.model.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Canonical


@Canonical
@JsonIgnoreProperties(ignoreUnknown = true)
class UserResponse {

    @JsonProperty(value = 'user_id')
    String userId

    @JsonProperty(value = 'user_email')
    String userEmail

    @JsonProperty(value = 'user_name')
    String userName
}
