package com.voting_system.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import java.io.Serializable

data class Completed(
    var id: Int,
    val userId: String,
    var voted: String = ""
) : Serializable

object Completeds: IntIdTable(){
    val user: Column<String> = varchar("user_id", 60).index()
    var voted: Column<String> = varchar("voted", 255)
}