package com.github.fcat97.localrecall

import com.github.fcat97.localrecall.data.Cursor
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val path_root = "/"

internal fun Application.module(cursor: Cursor) {
    install(CORS) {
        allowHost("*", schemes = listOf("chrome-extension"))
        allowHost("localhost")
        allowHost("localhost:8080")
        allowHost("127.0.0.1")

        allowHeader(HttpHeaders.AccessControlAllowOrigin)
    }

    install(ContentNegotiation) {
        json()
    }

    routing {
        get(path_root) {
            call.respondText("Ktor: Hello")
        }
    }
}