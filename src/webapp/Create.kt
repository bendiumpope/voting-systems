package com.voting_system.webapp

import com.voting_system.MIN_PASSWORD_LENGTH
import com.voting_system.MIN_USER_ID_LENGTH
import com.voting_system.model.EPSession
import com.voting_system.model.User
import com.voting_system.redirect
import com.voting_system.repository.VoteRepository
import com.voting_system.userNameValid
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*

const val CREATE = "/create"

@Location(CREATE)
data class Create(
    val userId: String="",
    val first: String="",
    val lastname: String = "",
    val address: String = "",
    val role: String = "",
    val password: String = "",
    val error: String = ""
)

fun Route.create(db: VoteRepository, hashFunction: (String) -> String){

    post<Create>{
        val user = call.sessions.get<EPSession>()?.let { user -> db.user(user.userId) }


        val createUserParameters = call.receive<Parameters>()

        val userId = createUserParameters["username"] ?: return@post call.redirect(it)
        val firstname = createUserParameters["firstname"] ?: return@post call.redirect(it)
        val lastname = createUserParameters["lastname"] ?: return@post call.redirect(it)
        val address = createUserParameters["address"] ?: return@post call.redirect(it)
        val role = createUserParameters["role"] ?: return@post call.redirect(it)
        val password = createUserParameters["password"] ?: return@post call.redirect(it)
        val confirmPassword = createUserParameters["confirmPassword"] ?: return@post call.redirect(it)

        println("$userId, $firstname, $lastname, $address, $role, $password, $confirmPassword")

        val signupError = Create(userId, firstname, lastname, address, role, password)

        when{
            password.length < MIN_PASSWORD_LENGTH ->
                call.redirect(signupError.copy(error = "Password should be at least $MIN_PASSWORD_LENGTH characters long"))
            password != confirmPassword ->
                call.redirect(signupError.copy(error = "Password/confirm password dont match"))
            userId.length < MIN_USER_ID_LENGTH ->
                call.redirect(signupError.copy(error = "Username should be at least $MIN_USER_ID_LENGTH characters long"))
            !userNameValid(userId) ->
                call.redirect(signupError.copy(error = "Username should consist of digits, letters, dots or underscores"))
            db.user(userId) != null ->
                call.redirect(signupError.copy(error = "User with the following username is already registered"))


            else -> {
                val hash = hashFunction(password)
                val newUser = User(userId, firstname, lastname, address, role, password, hash)

                try {
                    db.createUser(newUser)
//                    db.addactiveUser(userId, "OnLine")
                } catch (e: Throwable){
                    when{
                        db.user(userId) != null ->
                            call.redirect(signupError.copy(error = "User with the following username $ is already registered"))

                        else ->{
                            application.log.error("Failed to register user", e)
                            call.redirect(signupError.copy(error = "Failed to register"))
                            println("an error occured $e")
                        }
                    }
                }
                call.redirect(Create())
            }
        }
    }


    get<Create> {
        val user = call.sessions.get<EPSession>()?.let { db.user(it.userId) }

//        if (user?.role != "admin") {
//            call.redirect(Login())
//        } else {
            call.respond(FreeMarkerContent("signup.ftl", mapOf("error" to it.error)))
//        }
    }
}