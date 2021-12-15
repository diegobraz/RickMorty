apply(from = "../../gradle/android-library.gradle")

plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("plugin.serialization") version "1.4.32"
}

dependencies {
    api(projects.platform.foundation.common)
    api(projects.platform.foundation.design)

    implementation(libs.bundles.injection)
    implementation(libs.bundles.android.common)
    implementation(libs.bundles.listing)
    implementation(libs.kotlin.serialization)
    implementation(libs.bundles.components)
    implementation(libs.retrofit)
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    testImplementation(projects.platform.foundation.networking)
    testImplementation(projects.platform.testing)
    testImplementation(libs.bundles.unit.testing)

    androidTestImplementation(libs.bundles.android.testing)
    androidTestImplementation(libs.bundles.unit.testing)
}
