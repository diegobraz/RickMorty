import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

apply(from = "../gradle/android-application.gradle")

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(projects.features.home)
    implementation(projects.platform.foundation.networking)
    implementation(projects.platform.foundation.common)
    implementation(projects.platform.foundation.design)
    implementation(libs.bundles.injection)
    implementation(libs.bundles.android.common)
    implementation(libs.bundles.listing)
    implementation(libs.kotlin.serialization)
    implementation(libs.bundles.components)
    implementation(libs.retrofit)
    implementation(libs.kodein)
    implementation(libs.kodeinConf)
    implementation("com.google.dagger:hilt-android:2.37")
    kapt("com.google.dagger:hilt-android-compiler:2.37")
    implementation( "com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.dagger:hilt-android:2.37")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    androidTestImplementation(projects.platform.testing)
    androidTestImplementation(libs.kodeinAndroid)
    androidTestImplementation(libs.bundles.android.testing)
    androidTestImplementation(libs.bundles.unit.testing)

}