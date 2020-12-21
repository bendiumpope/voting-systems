package com.voting_system.webapp

import com.voting_system.model.EPSession
import com.voting_system.repository.VoteRepository
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*

const val DELETERECORDS = "/deleterecords"

@Location(DELETERECORDS)
class DeleteRecords

fun Route.deleterecords(db: VoteRepository) {

    get<DeleteRecords> {
        val user = call.sessions.get<EPSession>()?.let { db.user(it.userId) }

        val president = db.president()
        val generalSec = db.generalsec()
        val users = db.users()

        if(user != null && user.role == "admin"){
            val deletequery = db.clear()
            println("$deletequery")
            call.respond(FreeMarkerContent("login.ftl", null))
        }else{
            call.respond(FreeMarkerContent("login.ftl", null))
        }


    }
}