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

//const val RESULT = "/finishedresult"
const val RESULT = "/fini"

@Location(RESULT)
class Result

fun Route.finishedresult(db: VoteRepository) {
    get<Result> {
        val user = call.sessions.get<EPSession>()?.let { db.user(it.userId) }

        if(user == null){
            call.redirect(Login())
        }else{
            val electionResults = db.results()
            println(electionResults.toString())

            if (electionResults.isEmpty()){
                try{
                    val totalVotes = db.users().size
                    //President
                    val chinyemPres = db.president("DR-CHIYEM-ROLLINS-IYADI").size
                    val emekePres = db.president("EMEKE-IJEBOR").size

                    val totalnonVotes = totalVotes - (chinyemPres + emekePres)

                    db.addresult("Dr. Chiyem Rollins Iyadi", "President", chinyemPres, totalVotes, totalnonVotes)
                    db.addresult("Emeke Ijebor", "President", emekePres, totalVotes, totalnonVotes)

                    //Vice President
//                    val dnessVicePres = db.vicepresident("DNESS-PATIENCE-NKOYE-NKEM-KIFORDU").size
//                    db.addresult("Dness Patience Nkoye Nkem Kifordu", "Vice-President", dnessVicePres, totalVotes, totalnonVotes)

                    //General Secretary
//                    val chinyemGenSec = db.generalsec("DR-CHIYEM-ROLLINS-IYADI").size
//                    val emekeGenSec = db.generalsec("EMEKE-OHIANWUSI").size
                    val luckyGenSec = db.generalsec("LUCKY-ADAGBON").size

//                    db.addresult("Dr Chiyem Rollins Iyadi", "General-Secretary", chinyemGenSec, totalVotes, totalnonVotes)
//                    db.addresult("Emeke Ohianwusi", "General-Secretary", emekeGenSec, totalVotes, totalnonVotes)
                    db.addresult("Lucky Adagbon", "General-Secretary", luckyGenSec, totalVotes, totalnonVotes)

                    //Assistant General Secretary
                    val detAssGenSec = db.assistfinsec("EYEMONU-ONYEISI").size
                    db.addresult("Mr Enyemonu Onyeisi", "Assistant-General-Secretary", detAssGenSec, totalVotes, totalnonVotes)

                    //FINANCIAL SECRETARY
                    val asudikeFinSec = db.financialsec("ASUDIKE-TITUS").size
                    db.addresult("Asudike Titus", "Financial-Secretary", asudikeFinSec, totalVotes, totalnonVotes)

                    //TREASURER
                    val queenTreasurer = db.treasurer("QUEEN-ESAU-AGADAGIDI").size
                    db.addresult("Queen Esau Agadagidi", "Treasurer", queenTreasurer, totalVotes, totalnonVotes)

                    //SOCIAL PUBLICITY SECRETARY
                    val michaelPubSec = db.socialpub("MICHAEL-UGBECHIE").size
                    db.addresult("Michael Ugbechie", "Social-Publicity-Secretary", michaelPubSec, totalVotes, totalnonVotes)

                    //PROVOST
                    val preciousProvost = db.provost("PRECIOUS-EBUNDON").size
                    db.addresult("Precious Ebundon", "Provost", preciousProvost, totalVotes, totalnonVotes)

                    //DIASPORAL AFRICA
                    val cletusAfrica = db.diasporalafrica("CLETUS-UYANWANNE").size
                    db.addresult("Cletus Uyanwanne", "Diasporal-Africa", cletusAfrica, totalVotes, totalnonVotes)

                    //DIASPORAL Europe
                    val egbedeEurope = db.diasporaleurop("OBIAZIKWOR-EGBEDE").size
                    db.addresult("Obiazikwor Egbede", "Diasporal-Europe", egbedeEurope, totalVotes, totalnonVotes)


                    //DIASPORAL UK
                    val emekeUK = db.diasporaluk("EMEKE-EMEKIHIA").size
                    db.addresult("Emeke Emekihia", "Diasporal-UK", emekeUK, totalVotes, totalnonVotes)
                }catch (e: Throwable){
                    println("An Error Occurred $e")
                }

            }

        }

        val electionResults = db.results()
        val check = db.users().size
        println("total users: ${check}")

        call.respond(FreeMarkerContent("resu.ftl", mapOf("electionResults" to electionResults)))
//        call.respond(FreeMarkerContent("results.ftl", mapOf("electionResults" to electionResults)))
    }
}