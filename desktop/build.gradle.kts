plugins {
    kotlin("jvm")
}

val mainClassName = "com.github.caay2000.rrt.DesktopLauncher"
val assetsDir = file("../assets")

val jvmArgsForMac = listOf("-XstartOnFirstThread", "-Djava.awt.headless=true")
tasks.register<JavaExec>("run") {
    jvmArgs = mutableListOf<String>()
    if ("mac" in System.getProperty("os.name").toLowerCase())
        (jvmArgs as MutableList<String>).addAll(jvmArgsForMac)
    // These are non-standard, only available/necessary on Mac.
    dependsOn(tasks.getByName("classes"))
    mainClass.set(mainClassName)
    classpath = sourceSets.main.get().runtimeClasspath
    standardInput = System.`in`
    workingDir = assetsDir
    isIgnoreExitValue = true
}

tasks.register<JavaExec>("debug") {
    jvmArgs = jvmArgsForMac
    dependsOn(tasks.getByName("classes"))
    mainClass.set(mainClassName)
    classpath = sourceSets.main.get().runtimeClasspath
    standardInput = System.`in`
    workingDir = assetsDir
    isIgnoreExitValue = true
    debug = true
}

tasks.register<Jar>("dist") { // Compiles the jar file
    dependsOn(tasks.getByName("classes"))
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(files(sourceSets.main.get().output.resourcesDir))
    from(files(sourceSets.main.get().output.classesDirs))
    from({ (configurations.runtimeClasspath.get().resolve() + configurations.compileClasspath.get().resolve()).map { if (it.isDirectory) it else zipTree(it) } })
    from(files(assetsDir))
    archiveFileName.set("rrt.jar")
    manifest {
        attributes(mapOf("Main-Class" to mainClassName, "Specification-Version" to BuildConfiguration.appVersion))
    }
}

dependencies {
    implementation(project(":core"))
    api("com.badlogicgames.gdx:gdx-backend-lwjgl3:${BuildConfiguration.Version.libGdx}")
    api("com.badlogicgames.gdx:gdx-platform:${BuildConfiguration.Version.libGdx}:natives-desktop")
    api("org.jetbrains.kotlin:kotlin-stdlib:${BuildConfiguration.Version.kotlin}")
}
