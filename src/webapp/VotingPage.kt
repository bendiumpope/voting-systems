package com.voting_system.webapp

import com.voting_system.model.Completed
import com.voting_system.model.EPSession
import com.voting_system.redirect
import com.voting_system.repository.VoteRepository
import com.voting_system.securityCode
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*

const val VOTINGPAGE = "/votingpage"

@Location(VOTINGPAGE)
class Votingpage

fun Route.votingpage(db: VoteRepository, hashFunction: (String) -> String) {
    get<Votingpage> {
        val user = call.sessions.get<EPSession>()?.let { db.user(it.userId) }

        if (user == null) {
            call.redirect(Login())
        } else {
            val completed : Completed? = db.completed(user.userId)

            if(completed?.voted == "Completed"){
//                println("${completed?.voted}")
                call.redirect(Waiting())
            }else{
//                println("${user.userId}")
                val date = System.currentTimeMillis()
                val code = call.securityCode(date, user, hashFunction)
                call.respond(FreeMarkerContent("votingpage.ftl", mapOf("date" to date, "code" to code)))
            }
        }

    }

    post<Votingpage>{
        val user = call.sessions.get<EPSession>()?.let { db.user(it.userId) }

        val params = call.receiveParameters()
        val action = params["action"] ?: throw java.lang.IllegalArgumentException("Missing parameter: action")

        if(user == null){
            call.redirect(Login())
        }else{
            when (action){
                "add" -> {

                    val president = params["president"] ?: throw IllegalArgumentException("Missing parameter: President")
                    val vicepresident = params["vicepresident"] ?: throw IllegalArgumentException("Missing parameter: Vice President")
                    val generalsec = params["generalsec"] ?: throw IllegalArgumentException("Missing parameter: General Secretary")
                    val assistgensec = params["assistgensec"] ?: throw IllegalArgumentException("Missing parameter: Assist General Secretary")
                    val financialsec = params["financialsec"] ?: throw IllegalArgumentException("Missing parameter: Financial Secretary")
                    val treasurer = params["treasurer"] ?: throw IllegalArgumentException("Missing parameter: Treasurer")
                    val socialpubsec = params["socialpubsec"] ?: throw IllegalArgumentException("Missing parameter: Social Public Secretary")
                    val provost = params["provost"] ?: throw IllegalArgumentException("Missing parameter: Provost")
                    val diasporalafrica = params["diasporalafrica"] ?: throw IllegalArgumentException("Missing parameter: Diasporal Africa")
                    val diasporaluk = params["diasporaluk"] ?: throw IllegalArgumentException("Missing parameter: Diasporal UK")
                    val diasporaleurop = params["diasporaleurop"] ?: throw IllegalArgumentException("Missing parameter: Diasporal Europe")

                    try{
                        db.addpresident(user.userId, president)
                        db.addvicepresident(user.userId, vicepresident)
                        db.addgeneralsec(user.userId, generalsec)
                        db.addassistfinsec(user.userId, assistgensec)
                        db.addfinancialsec(user.userId, financialsec)
                        db.addtreasurer(user.userId, treasurer)
                        db.addsocialpub(user.userId, socialpubsec)
                        db.addprovost(user.userId, provost)
                        db.adddiasporalafrica(user.userId, diasporalafrica)
                        db.adddiasporaluk(user.userId, diasporaluk)
                        db.adddiasporaleurop(user.userId, diasporaleurop)
                    }catch (e: Throwable){
                        println("an Error Occured $e")
                    }
                }
            }
            db.addcompleted(user.userId, "Completed")
            call.redirect(Waiting())
        }
    }
}