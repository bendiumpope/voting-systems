package com.voting_system.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import java.io.Serializable

data class President(
    var id: Int,
    val userId: String,
    var voted_president: String=""
) : Serializable

object Presidents: IntIdTable(){
    val user: Column<String> = varchar("user_id", 60).index()
    var voted_president: Column<String> = varchar("voted_president", 255)
}