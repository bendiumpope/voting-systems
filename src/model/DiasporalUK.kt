package com.voting_system.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import java.io.Serializable

data class DiasporalUK(
    var id: Int,
    val userId: String,
    var voted_diasporal_uk: String=""
) : Serializable

object DiasporalUks: IntIdTable(){
    val user: Column<String> = varchar("user_id", 60).index()
    var voted_diasporal_uk: Column<String> = varchar("voted_diasporal_uk", 255)
}