import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
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
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:${project["dokka-gradle-plugin_version"]}")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "13"
}