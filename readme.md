### Issue with Kotlin Multiplatform JVM ktor server

---

#### Problem
Following Ktor-server documentation for JVM target works fine. But when I try to 
do the same in a multiplatform module, it fails.

There are two subprojects in this directory.
1. `serverJvm`: This project works as expected. Server starts by running `./gradlew :serverJvm:runFatJar` command.
2. `server`: This is a multiplatform project. There are two target inside this.
   1. `kotlin/native` target: Which is running perfectly as expected by `./gradlew :server:runDebugExecutableLinux`.
   2. `kotlin/jvm` target: **this fails to run**. The generated fatJar with `./gradlew :server:runFatJar` doesn't contain any classes.
      Ktor plugin can't detect the source for JVM target in multiplatform module.