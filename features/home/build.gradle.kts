import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

apply(from = "../../gradle/android-library.gradle")

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.28-alpha")


    testImplementation(projects.platform.foundation.networking)
    testImplementation(projects.platform.testing)
    testImplementation(libs.bundles.unit.testing)

    androidTestImplementation(libs.bundles.android.testing)
    androidTestImplementation(libs.bundles.unit.testing)
}
