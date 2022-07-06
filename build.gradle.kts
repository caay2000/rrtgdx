plugins {
    kotlin("jvm") version BuildConfiguration.Version.kotlin
    id("info.solidsoft.pitest") version "1.7.4"
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
}

group = "com.github.caay2000"
version = "1.0-SNAPSHOT"

tasks.withType<Wrapper> {
    gradleVersion = BuildConfiguration.Version.gradle
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    runtimeOnly("com.android.tools.build:gradle:7.0.4")
    runtimeOnly("com.mobidevelop.robovm:robovm-gradle-plugin:2.3.16")
    runtimeOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
}

allprojects {

    version = "1.0"

    repositories {
        mavenLocal()
        mavenCentral()
        google()
        gradlePluginPortal()
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/releases/") }
        maven { url = uri("https://jitpack.io") }
    }
}
