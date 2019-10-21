package com.thezer0team.shredderapi.dto.transform

import com.thezer0team.shredderapi.model.UserEntity
import com.thezer0team.shredderapi.model.request.UserRequest
import com.thezer0team.shredderapi.model.response.UserResponse
import org.springframework.stereotype.Component

@Component
class UserTransform {


    static UserEntity getEntityFromRequest(UserRequest userRequest) {

        return new UserEntity(
                userName: userRequest.userName,
                userEmail: userRequest.userEmail,
        )
    }

    static UserResponse getResponseFromEntity(UserEntity userEntity) {

        return new UserResponse(
                userId: userEntity.userId,
                userEmail: userEntity.userEmail,
                userName: userEntity.userName,
        )
    }
}
