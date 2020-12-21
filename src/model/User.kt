package com.voting_system.model

import io.ktor.auth.*
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.io.Serializable

data class User (
    val userId: String,
    var firstname: String,
    var lastname: String,
    var address: String,
    var role: String,
    val password: String,
    val passwordHash: String
) : Serializable, Principal

object Users: Table(){
    val id = varchar("id", 20).primaryKey().uniqueIndex()
    var firstname: Column<String> = varchar("firstname", 255)
    var lastname: Column<String> = varchar("lastname", 255)
    var address: Column<String> = varchar("address", 255)
    var role: Column<String> = varchar("role", 255)
    var password = varchar("password", 64)
    var passwordHash = varchar("password_hash", 64)
}