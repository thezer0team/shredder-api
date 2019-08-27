package com.thezer0team.shredderapi.repository

import com.thezer0team.shredderapi.model.UserEntity
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
@EnableScan
interface UserRepository extends CrudRepository<UserEntity, String> {
}