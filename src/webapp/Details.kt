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

const val DETAILS = "/details"

@Location(DETAILS)
class Details

fun Route.details(db: VoteRepository) {

    get<Details> {
        val user = call.sessions.get<EPSession>()?.let { db.user(it.userId) }

        val president = db.president()
        val generalSec = db.generalsec()
        val users = db.users()

        if(user != null && user.role == "admin"){
            call.respond(FreeMarkerContent("details.ftl", mapOf("president" to president, "generalSec" to generalSec)))
        }else{
            call.respond(FreeMarkerContent("waiting.ftl", mapOf("president" to president, "generalSec" to generalSec)))
        }


    }
}