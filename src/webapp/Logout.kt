package com.voting_system.webapp

import com.voting_system.model.EPSession
import com.voting_system.redirect
import com.voting_system.repository.VoteRepository
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.routing.*
import io.ktor.sessions.*

const val LOGOUT = "/logout"

@Location(LOGOUT)
class Logout

fun Route.logout(db: VoteRepository) {

    get<Logout> {
        val user = call.sessions.get<EPSession>()?.let { db.user(it.userId) }
//        val activeUser = db.activeUser(user!!.userId)
//
//        try {
//            db.updateactiveUser(activeUser!!.id, user.userId, "OffLine")
//        } catch (e: Throwable){
//            println("an error occured $e")
//        }

        call.sessions.clear<EPSession>()
        call.redirect(Login())
    }
}