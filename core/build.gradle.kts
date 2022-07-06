plugins {
    kotlin("jvm")
    id("info.solidsoft.pitest")
    id("org.jlleitschuh.gradle.ktlint")
}

dependencies {
    api("com.badlogicgames.gdx:gdx:${BuildConfiguration.Version.libGdx}")
    api("com.badlogicgames.gdx:gdx-ai:${BuildConfiguration.Version.libGdxAi}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${BuildConfiguration.Version.kotlin}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${BuildConfiguration.Version.kotlin}")
}
