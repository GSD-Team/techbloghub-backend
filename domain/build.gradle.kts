import org.springframework.boot.gradle.tasks.bundling.BootJar

repositories {
    mavenCentral()
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("com.querydsl:querydsl-core")

    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta") //QueryDSL 의존성(jakarta.persistence 패키지 이용시, 마지막 ":jpa" 제거)
    kapt("org.springframework.boot:spring-boot-configuration-processor") //QueryDSL 의존성
    implementation(project(":core"))
}

val bootJar: BootJar by tasks
val jar: Jar by tasks

bootJar.enabled = false
jar.enabled = true
jar.duplicatesStrategy = DuplicatesStrategy.EXCLUDE