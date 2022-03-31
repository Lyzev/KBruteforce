import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URL

plugins {
    kotlin("jvm") version "1.5.10"
    id("org.jetbrains.dokka") version "1.6.10"
}

operator fun Project.get(property: String): String {
    return property(property) as String
}

group = "me.lyzev"
version = "1.0"

repositories {
    mavenCentral()
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets {
        named("main") {
            moduleName.set("Dokka Gradle Documentation")
            includes.from("README.md")
            sourceLink {
                localDirectory.set(file("src/main/kotlin"))
                remoteUrl.set(URL("https://github.com/Lyzev/KBruteforce/tree/gh-pages/dokka"))
                remoteLineSuffix.set("#L")
            }
        }
    }
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "13"
}