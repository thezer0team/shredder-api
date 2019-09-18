package com.thezer0team.shredderapi.dao

import com.thezer0team.shredderapi.model.UserEntity
import com.thezer0team.shredderapi.repository.UserRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserDao {

    @Autowired
    UserRepository userRepository

    UserEntity createNewUser(UserEntity userEntity) {
        return userRepository.save(userEntity)
    }

    UserEntity readUserById(String userId) {
        return userRepository.findById(userId)
    }

    UserEntity updateUser(UserEntity userEntity) {
        return userRepository.save(userEntity)
    }
}
