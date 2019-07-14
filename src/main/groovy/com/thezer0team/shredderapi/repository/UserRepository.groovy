package com.thezer0team.shredderapi.repository

import com.thezer0team.shredderapi.model.UserEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository extends MongoRepository<UserEntity, String> {
}