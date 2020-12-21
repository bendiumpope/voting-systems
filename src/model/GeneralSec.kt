package com.voting_system.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import java.io.Serializable

data class GeneralSec(
    var id: Int,
    val userId: String,
    var voted_general_sec: String=""
) : Serializable

object GeneralSecs: IntIdTable(){
    val user: Column<String> = varchar("user_id", 60).index()
    var voted_general_sec: Column<String> = varchar("voted_general_sec", 255)
}