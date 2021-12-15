apply(from = "../../../gradle/commons.gradle")

plugins {
    kotlin("jvm")
}

dependencies {

    api(projects.platform.domain)
    implementation(libs.kodein)
    implementation(libs.kotlin.serialization)
    implementation(libs.kotlin.coroutines)
    implementation(libs.bundles.networking)

    testImplementation(projects.platform.testing)
    testImplementation(libs.bundles.unit.testing)
}