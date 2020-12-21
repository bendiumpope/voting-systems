package com.voting_system.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import java.io.Serializable

data class SocialPub(
    var id: Int,
    val userId: String,
    var voted_social_pub: String=""
) : Serializable

object SocialPubs: IntIdTable(){
    val user: Column<String> = varchar("user_id", 60).index()
    var voted_social_pub: Column<String> = varchar("voted_social_pub", 255)
}