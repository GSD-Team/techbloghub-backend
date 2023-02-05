import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation("com.querydsl:querydsl-core")
    api("org.springframework.cloud:spring-cloud-starter-openfeign:4.0.1")
}

val bootJar: BootJar by tasks
val jar: Jar by tasks

bootJar.enabled = false
jar.enabled = true
jar.duplicatesStrategy = DuplicatesStrategy.EXCLUDE