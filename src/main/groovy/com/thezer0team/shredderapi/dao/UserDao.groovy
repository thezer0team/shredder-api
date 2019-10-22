package com.thezer0team.shredderapi.dao

import com.google.cloud.datastore.Key
import com.thezer0team.shredderapi.model.UserEntity
import com.thezer0team.shredderapi.model.request.UserRequest
import com.thezer0team.shredderapi.repository.UserRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Slf4j
@Component
class UserDao {

    @Autowired
    UserRepository userRepository

//    @Value('${spring.cloud.gcp.datastore.namespace:shredder-dev}')
    private static final String KEY_PROJECT_ID = 'shredder-dev'

    private static final String KEY_KIND = 'UserEntityTable'

    UserEntity createNewUser(UserEntity userEntity) {

        if(readUserByEmail( userEntity.userEmail).size() > 0) {
            log.warn("User ${userEntity.userEmail} already exists", new ResourceException("User ${UserRequest.userEmail}"))
        }

        userEntity.userId = getNextId(userEntity.userEmail)

        return userRepository.save(userEntity)
    }

    UserEntity readUserById(String userId) {
        return userRepository.findById(userId).get()
    }

    UserEntity updateUser(UserEntity userEntity) {
        return userRepository.save(userEntity)
    }

    def readUserByEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail)
    }

    private static Key getNextId(String userEmail) {

        return Key.newBuilder(KEY_PROJECT_ID, KEY_KIND, userEmail).build()
    }

}
