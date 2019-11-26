package com.thezer0team.shredderapi.repository

import com.google.cloud.datastore.Key
import com.thezer0team.shredderapi.model.UserEntity
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository


interface UserRepository extends DatastoreRepository<UserEntity, Key> {

    List<UserEntity> findByUserEmail(String userEmail)

}