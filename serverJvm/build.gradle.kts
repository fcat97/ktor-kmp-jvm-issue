plugins {
    application
    kotlin("jvm")

    alias(libs.plugins.ktor)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.kotlinSerialization)
}

group = "com.github.fcat97.localrecall"
version = "0.1.4"
val appName = "local-recall-server_$version"

sqldelight {
    databases {
        create("Database") {
            packageName.set("com.github.fcat97.localrecall")
        }
    }
}

application {
    mainClass.set("com.github.fcat97.localrecall.ApplicationKt")
}

dependencies {
    implementation(libs.sqldelight.jvmDriver)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.cio)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.serialization.json)
    implementation(libs.ktor.server.negotiation)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.okio)
}
