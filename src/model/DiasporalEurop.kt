package com.voting_system.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import java.io.Serializable

data class DiasporalEurop(
    var id: Int,
    val userId: String,
    var voted_diasporal_europ: String=""
) : Serializable

object DiasporalEurops: IntIdTable(){
    val user: Column<String> = varchar("user_id", 60).index()
    var voted_diasporal_europ: Column<String> = varchar("voted_diasporal_europ", 255)
}