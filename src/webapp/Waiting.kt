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

const val WAITING = "/waiting"

@Location(WAITING)
class Waiting

fun Route.waiting(db:VoteRepository) {
    get<Waiting> {
        val user = call.sessions.get<EPSession>()?.let { db.user(it.userId) }

        if(user == null){
            call.redirect(Login())
        }else{

        call.respond(FreeMarkerContent("waiting.ftl", null))

        }
    }
}