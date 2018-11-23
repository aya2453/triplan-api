import org.jetbrains.kotlin.cli.jvm.main
import org.jetbrains.kotlin.config.KotlinCompilerVersion

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        val kotlin_version: String by project
        classpath(kotlin("gradle-plugin", version = kotlin_version))
    }
}

plugins {
    kotlin("jvm") version "1.3.10"
    kotlin("kapt") version "1.3.10"
    application
}

group = "triplan-api"
version = "1.0.0-SNAPSHOT"

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

sourceSets {
    getByName("main").java.srcDirs("src")
    getByName("test").java.srcDirs("test")
    getByName("main").resources.srcDirs("resources")
    getByName("test").resources.srcDirs("testresources")
}

repositories {
    mavenLocal()
    jcenter()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
}

dependencies {
    val ktor_version: String by project
    val logback_version: String by project
    val moshi_version: String by project
    implementation(kotlin("stdlib-jdk8", KotlinCompilerVersion.VERSION))
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-auth:$ktor_version")
    implementation("io.ktor:ktor-auth-jwt:$ktor_version")
    implementation("com.squareup.moshi:moshi:$moshi_version")
    implementation("com.squareup.moshi:moshi-kotlin:$moshi_version")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:$moshi_version")
//    implementation("com.squareup.moshi:moshi-adapters:$moshi_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
}
