package com.thezer0team.shredderapi.dao

import com.thezer0team.shredderapi.model.UserEntity
import com.thezer0team.shredderapi.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserDao {

    @Autowired
    UserRepository userRepository

    @Transactional
    UserEntity createNewUser(UserEntity userEntity) {
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
}
