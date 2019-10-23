package com.thezer0team.shredderapi.model.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Canonical

import javax.validation.constraints.NotEmpty

@Canonical
@JsonIgnoreProperties(ignoreUnknown = true)
class UserRequest {

    @JsonProperty(value = 'user_email')
    @NotEmpty
    public String userEmail

    @JsonProperty(value = 'user_name')
    @NotEmpty
    String userName
}
