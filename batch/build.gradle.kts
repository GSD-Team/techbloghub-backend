import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-batch")
    implementation("com.querydsl:querydsl-jpa:5.0.0") //QueryDSL 의존성

    testImplementation("org.springframework.batch:spring-batch-test")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta") //QueryDSL 의존성

    implementation(project(":domain"))
    implementation(project(":core"))
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
