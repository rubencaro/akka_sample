import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm") version "1.3.10"
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("com.typesafe.akka:akka-http_2.12:10.1.5")
    implementation("com.typesafe.akka:akka-stream_2.12:2.5.12")

    testCompile(kotlin("test-junit"))
    testCompile("junit:junit:4.12")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.3.2")
    testCompile("org.junit.jupiter:junit-jupiter-api:5.3.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.2")

    testImplementation("com.typesafe.akka:akka-http-testkit_2.12:10.1.5")
}

application {
    // Define the main class for the application (note the ending 'Kt')
    mainClassName = "akka_sample.AppKt"
}

tasks.withType<Test> {
    dependsOn("cleanTest") // force test execution
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
        showStandardStreams = true
        showStackTraces = true
        exceptionFormat = TestExceptionFormat.FULL
	}
    // addTestListener(object : TestListener {
    //     override fun beforeSuite(suite: TestDescriptor) {}
    //     override fun beforeTest(testDescriptor: TestDescriptor) {}
    //     override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) {}
    //     override fun afterSuite(suite: TestDescriptor, result: TestResult) {
    //         if (suite.getParent() == null) {
    //             println("\nTest summary: ${result.testCount} tests, " +
    //                     "${result.successfulTestCount} succeeded, " +
    //                     "${result.failedTestCount} failed, " +
    //                     "${result.skippedTestCount} skipped")
    //         }
    //     }
    // })
}
