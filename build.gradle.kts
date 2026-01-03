plugins {
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.5.10-SNAPSHOT"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "ru.corthoscode"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Testcontainers
    testImplementation("org.testcontainers:junit-jupiter:1.21.4")
    testImplementation("org.testcontainers:mongodb:1.21.4")

    // Flapdoodle
    testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo:4.22.0")
    testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo.spring3x:4.22.0")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}