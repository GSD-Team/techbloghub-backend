import org.springframework.boot.gradle.tasks.bundling.BootJar


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta") //QueryDSL 의존성
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")


    //JWT
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
    implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")


    implementation(project(":domain"))
    implementation(project(":core"))

    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
}

val bootJar: BootJar by tasks
val jar: Jar by tasks

bootJar.enabled = true
jar.enabled = false
jar.duplicatesStrategy = DuplicatesStrategy.EXCLUDE

val test: Test by tasks
test.onlyIf {
    !project.hasProperty("test")
}
