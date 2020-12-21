package com.voting_system

import com.voting_system.model.EPSession
import com.voting_system.model.User
import com.voting_system.repository.DatabaseFactory
import com.voting_system.repository.VoteRepository
import com.voting_system.webapp.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import freemarker.cache.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.features.*
import io.ktor.freemarker.*
import io.ktor.gson.*
import io.ktor.http.content.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.sessions.*
import java.net.URI
import java.util.concurrent.TimeUnit

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(DefaultHeaders)

    install(StatusPages){
        exception<Throwable>{e ->
            call.respondText(e.localizedMessage,
                ContentType.Text.Plain, HttpStatusCode.InternalServerError)
        }
    }

    install(ContentNegotiation){
        gson()
    }

    install(FreeMarker){
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

//    install(Authentication){
//        basic(name = "auth"){
//           realm = "ktor server"
//            validate{ credentials ->
//                if(credentials.password == "${credentials.name}123") User(credentials.name) else null
//            }
//        }
//    }

    install(Locations)

    install(Sessions){
        cookie<EPSession>("SESSION"){
            transform(SessionTransportTransformerMessageAuthentication(hashKey))
        }
    }
    val hashFunction = { s: String -> hash(s) }
    DatabaseFactory.init()

    val db = VoteRepository()

    val jwtServices = JwtService()

    install(Authentication){
        jwt ("jwt") {
            verifier(jwtServices.verifier)
            realm = "voting_system app"
            validate {
                val payload = it.payload
                val claim = payload.getClaim("id")
                val claimString = claim.asString()
                val user = db.user(claimString)
                user
            }
        }
    }
    routing {
        // Static feature. Try to access `/static/ktor_logo.svg`
        static("/static") {
            resources("staticfiles")
        }

        create(db, hashFunction)
        login(db, hashFunction)
        index(db)
        votingpage(db, hashFunction)
        waiting(db)
        logout(db)
        finishedresult(db)
        details(db)
        users(db)
        deleterecords(db)
    }
}

const val API_VERSION = "/api/v1"

suspend fun ApplicationCall.redirect(location: Any){
    respondRedirect(application.locations.href(location))
}

fun ApplicationCall.verifyCode(date: Long, user:User, code:String, hashFunction: (String) -> String) =
    securityCode(date,user,hashFunction) == code &&
            (System.currentTimeMillis()-date).let { it > 0 && it < TimeUnit.MILLISECONDS.convert(2, TimeUnit.HOURS) }

fun ApplicationCall.securityCode(date: Long, user:User, hashFunction: (String) -> String) =
    hashFunction("$date:${user.userId}:${request.host()}:${refererHost()}")

fun ApplicationCall.refererHost() = request.header(HttpHeaders.Referrer)?.let { URI.create(it).host }

val ApplicationCall.apiUser get() = authentication.principal<User>()

