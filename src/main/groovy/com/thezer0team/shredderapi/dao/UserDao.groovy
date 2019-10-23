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

    @Value('${spring.cloud.gcp.project.id:shredder-dev}')
    private String keyProjectId

    private static final String KEY_KIND = 'UserEntityTable'

    UserEntity createNewUser(UserEntity userEntity) {

        if(readUserByEmail( userEntity.userEmail).size() > 0) {
            log.warn("User ${userEntity.userEmail} already exists", new ResourceException("User ${UserRequest.userEmail}"))
        }

        userEntity.userId = getNextId(userEntity.userEmail)

        return userRepository.save(userEntity)
    }

    UserEntity readUserById(Key userId) {
        return userRepository.findById(userId).get()
    }

    UserEntity updateUser(UserEntity userEntity) {
        return userRepository.save(userEntity)
    }

    def readUserByEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail)
    }

    List<String> getAllUserIds() {

        List<String> userIdList =  userRepository.findAll().collect {UserEntity userEntity1 ->
            return userEntity1.userId.toString()
        }

        return userIdList
    }

    List<String> getAllUserEmails() {

        List<String> userEmailList =  userRepository.findAll().collect {UserEntity userEntity1 ->
            return userEntity1.userEmail
        }

        return userEmailList
    }

    private Key getNextId(String userEmail) {

        return Key.newBuilder(keyProjectId, KEY_KIND, userEmail).build()
    }

    UserEntity getUserByEmail(String userEmail) {

        UserEntity user = userRepository.findByUserEmail(userEmail)

        if(!user) {
            log.warn("Unable to locate account for $userEmail", new ResourceException("$userEmail not found"))
        }
git
        return user
    }
}
