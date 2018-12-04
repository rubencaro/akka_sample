/*
 * This file contains a sample Kotlin application project to get you started.
 */

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM
    kotlin("jvm") version "1.3.10"

    // Apply the application to add support for building a CLI application
    application
}

repositories {
    // Use jcenter for resolving your dependencies.
    jcenter()
}

dependencies {
    // Use the Kotlin JDK 8 extended standard library
    implementation(kotlin("stdlib-jdk8"))

    // Use the Kotlin JUnit 5 integration
    testImplementation(kotlin("test-junit5"))
}

application {
    // Define the main class for the application (note the ending 'Kt')
    mainClassName = "kt_sample.AppKt"
}
