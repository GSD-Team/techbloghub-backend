import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    
}

val bootJar: BootJar by tasks
val jar: Jar by tasks

bootJar.enabled = false
jar.enabled = true
jar.duplicatesStrategy = DuplicatesStrategy.EXCLUDE