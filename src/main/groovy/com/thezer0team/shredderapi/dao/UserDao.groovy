package com.thezer0team.shredderapi.dao

import com.google.cloud.datastore.Key
import com.thezer0team.shredderapi.model.UserEntity
import com.thezer0team.shredderapi.model.request.UserRequest
import com.thezer0team.shredderapi.repository.UserRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
<<<<<<< HEAD
import org.springframework.http.ResponseEntity
=======
import org.springframework.beans.factory.annotation.Value
>>>>>>> 151d3bdf74f9b2018677f63e2601d192f996f20f
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
<<<<<<< HEAD
        if(readUserByEmail(userEntity.userEmail).size() > 0) {
            log.warn("User ${userEntity.userEmail} already exists", new ResourceException("User ${UserRequest.userEmail}"))
        }

=======

        if(readUserByEmail( userEntity.userEmail).size() > 0) {
            log.warn("User ${userEntity.userEmail} already exists", new ResourceException("User ${UserRequest.userEmail}"))
        }

        userEntity.userId = getNextId(userEntity.userEmail)

>>>>>>> 151d3bdf74f9b2018677f63e2601d192f996f20f
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

<<<<<<< HEAD
    ResponseEntity<List<String>> getAllUsers() {
        List<String> userIdList =  userRepository.findAll().collect {UserEntity userEntity1 ->
            userEntity1.userId
        }

        return userIdList
    }
=======
    private static Key getNextId(String userEmail) {

        return Key.newBuilder(KEY_PROJECT_ID, KEY_KIND, userEmail).build()
    }

>>>>>>> 151d3bdf74f9b2018677f63e2601d192f996f20f
}
