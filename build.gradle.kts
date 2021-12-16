plugins {
    id("com.savvasdalkitsis.module-dependency-graph") version "0.9"
}

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("org.jmailen.gradle:kotlinter-gradle:3.4.4")
        classpath("com.squareup.sqldelight:gradle-plugin:1.4.4")
        classpath("com.adarshr:gradle-test-logger-plugin:3.0.0")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
    }
}


allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}