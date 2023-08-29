package com.example.plugins

import com.example.routes.login.logInRoute
import com.example.routes.login.signUpRoute
import com.example.routes.user.authenticationTestRoute
import com.example.routes.user.getUserIdRoute
import com.example.data.user.MongoUserDataSource
import com.example.db.getDatabaseClient
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {

    val db = getDatabaseClient()
    val userDataSource = MongoUserDataSource(db)

    routing {
        // Example logging from route
        //call.application.environment.log.info("Hello from ~word!")

        signUpRoute(userDataSource)
        logInRoute(userDataSource)
        authenticationTestRoute()
        getUserIdRoute()
    }
}
