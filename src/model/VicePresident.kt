package com.voting_system.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import java.io.Serializable

data class VicePresident(
    var id: Int,
    val userId: String,
    var voted_vice_president: String=""
) : Serializable

object VicePresidents: IntIdTable(){
    val user: Column<String> = varchar("user_id", 60).index()
    var voted_vice_president: Column<String> = varchar("voted_vice_president", 255)
}