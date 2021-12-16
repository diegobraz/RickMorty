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

    implementation(libs.kodein)
    implementation(libs.kodeinConf)
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.28-alpha")

    androidTestImplementation(projects.platform.testing)
    androidTestImplementation(libs.kodeinAndroid)
    androidTestImplementation(libs.bundles.android.testing)
    androidTestImplementation(libs.bundles.unit.testing)

}