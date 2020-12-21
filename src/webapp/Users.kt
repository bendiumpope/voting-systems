package com.voting_system.webapp

import com.voting_system.model.EPSession
import com.voting_system.redirect
import com.voting_system.repository.VoteRepository
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*

const val USERS = "/users"

@Location(USERS)
class Users

fun Route.users(db: VoteRepository) {

    get<Users> {
        val user = call.sessions.get<EPSession>()?.let { db.user(it.userId) }
        val users = db.users()

        if(user != null && user.role == "admin"){

        call.respond(FreeMarkerContent("users.ftl", mapOf("users" to users)))
    }else{
            call.respond(FreeMarkerContent("waiting.ftl", mapOf("users" to users)))
        }
    }
}