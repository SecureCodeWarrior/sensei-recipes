plugins {
    kotlin("jvm") version "1.3.71"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

var log4jversion = "2.15.1"

dependencies {
    implementation(group="org.apache.logging.log4j", name="log4j-api", version="2.15.1")
    implementation("org.apache.logging.log4j", "log4j-core", "2.15.1")
    implementation(group="org.apache.logging.log4j", name="log4j-api", version=log4jversion)
    implementation("org.apache.logging.log4j:log4j-core:2.15.1")
    implementation("org.apache.logging.log4j:log4j-core:$log4jversion")
    implementation(name="log4j-api", version="2.15.1", group="org.apache.logging.log4j")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}