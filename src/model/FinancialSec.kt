package com.voting_system.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import java.io.Serializable

data class FinancialSec(
    var id: Int,
    val userId: String,
    var voted_financial_sec: String=""
) : Serializable

object FinancialSecs: IntIdTable(){
    val user: Column<String> = varchar("user_id", 60).index()
    var voted_financial_sec: Column<String> = varchar("voted_financial_sec", 255)
}