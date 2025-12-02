import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("application")
    id("org.sonarqube") version "7.1.0.6387"
    id("checkstyle")
    id("jacoco")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application { mainClass.set("hexlet.code.App") }

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = setOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        showStandardStreams = true
    }
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }

sonar {
    properties {
        property("sonar.projectKey", "Someloseyouth_java-project-78")
        property("sonar.organization", "someloseyouth")
    }
}

tasks.register<Exec>("jshell") {
    group = "demo"
    description = "Запуск JShell"
    dependsOn("classes")
    val classpath = File("$buildDir/classes/java/main").absolutePath
    commandLine("jshell", "--class-path", classpath)
    standardInput = System.`in`
}