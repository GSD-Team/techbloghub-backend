import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("com.querydsl:querydsl-core")

    runtimeOnly("mysql:mysql-connector-java")
    kapt("com.querydsl:querydsl-apt:5.0.0:jpa") //QueryDSL 의존성
    kapt("org.springframework.boot:spring-boot-configuration-processor") //QueryDSL 의존성
    implementation(project(":core"))
}

val bootJar: BootJar by tasks
val jar: Jar by tasks

bootJar.enabled = false
jar.enabled = true
jar.duplicatesStrategy = DuplicatesStrategy.EXCLUDE