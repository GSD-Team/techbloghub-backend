import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Spring Boot Version : 3.0.2
 * Kotlin Version : 1.8.0
 */
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.8.0")
        classpath("org.jetbrains.kotlin:kotlin-noarg:1.8.0")
        classpath("io.spring.gradle:dependency-management-plugin:1.1.0")
    }
}

plugins {
    id("org.jetbrains.kotlin.jvm") version ("1.8.0")
    id("org.jetbrains.kotlin.plugin.jpa") version ("1.8.0")
    id("org.jetbrains.kotlin.plugin.spring") version ("1.8.0")
    id("org.jetbrains.kotlin.kapt") version ("1.8.0")
    id("org.springframework.boot") version ("3.0.2")
    id("io.spring.dependency-management") version ("1.1.0")
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    group = "com.gsd"
    version = "1.0"

    repositories {
        mavenCentral()
    }
    kapt {
        correctErrorTypes = true //NonExistentClass 오류 방지
    }

    tasks.test {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    kotlin {
        jvmToolchain(17)
    }


}

subprojects {
    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8") //필수
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3") //JSON 파싱 에러 대응.
        implementation("io.github.microutils:kotlin-logging-jvm:3.0.2")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine") //5.8.1
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}



tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}
kotlin {
    jvmToolchain(17)
}