package com.thezer0team.shredderapi.service


import com.thezer0team.shredderapi.dao.UserDao
import com.thezer0team.shredderapi.dto.transform.UserTransform
import com.thezer0team.shredderapi.model.UserEntity
import com.thezer0team.shredderapi.model.request.UserRequest
import com.thezer0team.shredderapi.model.response.UserResponse
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Slf4j
@Service
class UserService {

    @Autowired
    UserTransform userTransform

    @Autowired
    UserDao userDao

    UserEntity createUser(UserRequest userRequest) {

        return userDao.createNewUser(userTransform.getEntityFromRequest(userRequest))
    }

    UserResponse getResponseFromEntity(UserEntity userEntity) {

        return userTransform.getResponseFromEntity(userEntity)
    }

    List<String> getAllAccounts() {

        return userDao.getAllUserIds()
    }

    UserEntity getUser(UserRequest userRequest) {

        return userDao.getUserByEmail(userRequest.userEmail)
    }
}
