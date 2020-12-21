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

const val INDEX = "/index"

@Location(INDEX)
class Index

fun Route.index(db:VoteRepository) {
    get<Index> {
        val user = call.sessions.get<EPSession>()?.let { db.user(it.userId) }

        if(user == null){
            call.redirect(Login())
        }else{

        call.respond(FreeMarkerContent("index.ftl", null))

        }
    }
}