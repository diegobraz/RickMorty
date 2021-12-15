apply(from = "../../gradle/commons.gradle")

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.4.32"
}

dependencies {
    implementation(projects.platform.domain)
    implementation(projects.platform.foundation.networking)
    implementation(libs.bundles.kotlin.common)
}