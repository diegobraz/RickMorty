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
    implementation( "com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.dagger:hilt-android:2.37")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    kapt("com.google.dagger:hilt-android-compiler:2.37")
    implementation(  "com.github.bumptech.glide:glide:4.12.0")
    implementation("androidx.paging:paging-runtime-ktx:3.1.0")


    testImplementation(projects.platform.foundation.networking)
    testImplementation(projects.platform.testing)
    testImplementation(libs.bundles.unit.testing)

    androidTestImplementation(libs.bundles.android.testing)
    androidTestImplementation(libs.bundles.unit.testing)
}
