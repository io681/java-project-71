import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("java")
    id("checkstyle")
    application
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("info.picocli:picocli:4.7.5")
    annotationProcessor ("info.picocli:picocli-codegen:4.7.5")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application { mainClass.set("hexlet.code.App") }

tasks.test {
    useJUnitPlatform()

    maxHeapSize = "1G"

    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true    }

    finalizedBy(tasks.jacocoTestReport)
}

tasks.compileJava {
    options.release = 20
}


tasks.jacocoTestReport {
    reports {
        xml.required.set(true) }
}


