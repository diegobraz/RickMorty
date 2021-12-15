apply(from = "../../../gradle/android-library.gradle")

plugins {
    id("com.android.library")
    id("kotlin-android")
}

dependencies {

    api(projects.platform.domain)
    implementation(libs.bundles.injection)
    implementation(libs.kotlin.coroutines)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.android.common)
}
