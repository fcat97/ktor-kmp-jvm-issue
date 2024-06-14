plugins {
    application
    alias(libs.plugins.kotlinMultiplatform)
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

kotlin {
    val nativeTargets = listOf(
        //macosX64(),
        //macosArm64(),
        linuxX64("linux"),
        // mingwX64(), windows not supported
    )

    nativeTargets.forEach {
        it.apply {
            binaries {
                executable {
                    entryPoint = "$group.main"
                    baseName = appName
                }
            }
        }
    }

    // for jvm
    jvm()

    sourceSets {
        val linuxMain by getting {
            dependencies {
                implementation(libs.sqldelight.nativeDriver)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(libs.sqldelight.jvmDriver)
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(libs.logback)
                implementation(libs.ktor.server.core)
                implementation(libs.ktor.server.cio)
                implementation(libs.ktor.server.cors)
                implementation(libs.ktor.serialization.json)
                implementation(libs.ktor.server.negotiation)
                implementation(libs.kotlin.serialization.json)
                implementation(libs.okio)
            }
        }
    }

    configure(nativeTargets){
        binaries.configureEach{
            // https://github.com/ctripcorp/SQLlin/issues/48#issuecomment-1743865971
            linkerOpts += mutableListOf("-lsqlite3", "-L/lib/x86_64-linux-gnu", "--allow-shlib-undefined")
        }
    }
}
