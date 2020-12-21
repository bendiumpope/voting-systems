package com.voting_system.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import java.io.Serializable

data class Result (
    var id: Int,
    var name: String,
    var office: String,
    var votes_gotten: Int,
    var total_voters: Int,
    var total_non_voters: Int
): Serializable

object Results: IntIdTable(){
    var name: Column<String> = varchar("name", 255)
    var office: Column<String> = varchar("office", 255)
    var votes_gotten: Column<Int> = integer("votes_gotten")
    var total_voters: Column<Int> = integer("total_voters")
    var total_non_voters: Column<Int> = integer("total_non_voters")
}