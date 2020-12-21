package com.voting_system.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import java.io.Serializable

data class Treasurer(
    var id: Int,
    val userId: String,
    var voted_treasurer: String=""
) : Serializable

object Treasurers: IntIdTable(){
    val user: Column<String> = varchar("user_id", 60).index()
    var voted_treasurer: Column<String> = varchar("voted_treasurer", 255)
}