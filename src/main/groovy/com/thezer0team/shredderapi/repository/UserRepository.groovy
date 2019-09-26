package com.thezer0team.shredderapi.repository

import com.thezer0team.shredderapi.model.UserEntity
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository


interface UserRepository extends DatastoreRepository<UserEntity, String> {
}