package com.voting_system.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import java.io.Serializable

data class AssistFinSec(
    var id: Int,
    val userId: String,
    var voted_assist_fin_sec: String=""
) : Serializable

object AssistFinSecs: IntIdTable(){
    val user: Column<String> = varchar("user_id", 60).index()
    var voted_assist_fin_sec: Column<String> = varchar("voted_assist_fin_sec", 255)
}