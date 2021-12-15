apply(from = "../gradle/android-application.gradle")

plugins {
    id("com.android.application")
    id("kotlin-android")
}

dependencies {
    implementation(projects.features.home)
    implementation(projects.platform.foundation.networking)
    implementation(projects.platform.foundation.common)
    implementation(projects.platform.foundation.design)

    implementation(libs.kodein)
    implementation(libs.kodeinConf)

    androidTestImplementation(projects.platform.testing)
    androidTestImplementation(libs.kodeinAndroid)
    androidTestImplementation(libs.bundles.android.testing)
    androidTestImplementation(libs.bundles.unit.testing)

}