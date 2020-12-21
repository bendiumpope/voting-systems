package com.voting_system.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import java.io.Serializable

data class Provost(
    var id: Int,
    val userId: String,
    var voted_provost: String=""
) : Serializable

object Provosts: IntIdTable(){
    val user: Column<String> = varchar("user_id", 60).index()
    var voted_provost: Column<String> = varchar("voted_provost", 255)
}