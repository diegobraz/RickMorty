apply(from = "../../../gradle/android-library.gradle")

plugins {
    id("com.android.library")
    id("kotlin-android")
}

dependencies {
    implementation(projects.platform.domain)
    implementation(projects.platform.foundation.common)
    implementation(libs.kotlin.coroutines)
    implementation(libs.bundles.listing)
    implementation(libs.bundles.components)
    implementation(libs.bundles.lifecycle)
}
