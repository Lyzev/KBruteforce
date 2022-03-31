import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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

dependencies {
    dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:${project["dokka_version"]}")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "13"
}