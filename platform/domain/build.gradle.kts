apply(from = "../../gradle/commons.gradle")

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(libs.kotlin.coroutines)
    implementation(libs.kodein)
    testImplementation(libs.bundles.unit.testing)
    testImplementation(projects.platform.testing)
}
