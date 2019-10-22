package com.thezer0team.shredderapi.dao

import com.thezer0team.shredderapi.model.UserEntity
import com.thezer0team.shredderapi.model.request.UserRequest
import com.thezer0team.shredderapi.repository.UserRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Slf4j
@Component
class UserDao {

    @Autowired
    UserRepository userRepository

    @Transactional
    UserEntity createNewUser(UserEntity userEntity) {
        if(readUserByEmail(userEntity.userEmail).size() > 0) {
            log.warn("User ${userEntity.userEmail} already exists", new ResourceException("User ${UserRequest.userEmail}"))
        }

        return userRepository.save(userEntity)
    }

    @Transactional
    UserEntity readUserById(String userId) {
        return userRepository.findById(userId).get()
    }

    @Transactional
    UserEntity updateUser(UserEntity userEntity) {
        return userRepository.save(userEntity)
    }

    def readUserByEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail)
    }

    ResponseEntity<List<String>> getAllUsers() {
        List<String> userIdList =  userRepository.findAll().collect {UserEntity userEntity1 ->
            userEntity1.userId
        }

        return userIdList
    }
}
