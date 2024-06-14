package com.github.fcat97.localrecall

import com.github.fcat97.localrecall.data.InMemoryCursor
import io.ktor.server.cio.*
import io.ktor.server.engine.*

fun main(args: Array<String>) {
    val cursor = InMemoryCursor()

    embeddedServer(
        factory = CIO,
        port = SERVER_PORT,
        host = "localhost",
        module = { module(cursor) },
    ).start(wait = true)
}