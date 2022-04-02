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

tasks.getByName<DokkaTask>("dokkaHtml") {
    outputDirectory.set(buildDir.resolve("dokkaHtmlOutput"))
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "13"
}