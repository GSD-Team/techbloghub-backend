import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

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
    // 정식버전이 아닐 경우, 대버전 업 X
    version = "0.0.1"

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
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8") //필수
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        //JSON 파싱 에러 대응.
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
        //LocalDateTime 파싱 에러 대응.
        implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.0")
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

val bootJar: BootJar by tasks
val jar: Jar by tasks
bootJar.enabled = false
jar.enabled = true
/**
 * Please refer to https://docs.gradle.org/7.4/dsl/org.gradle.api.tasks.Copy.html#org.gradle.api.tasks.Copy:duplicatesStrategy for details.
 * 에러 대응
 */
jar.duplicatesStrategy = DuplicatesStrategy.EXCLUDE
