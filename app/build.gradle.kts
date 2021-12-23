import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

apply(from = "../gradle/android-application.gradle")

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
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
    //Hilt
    implementation("com.google.dagger:hilt-android:2.37")
    implementation("androidx.paging:paging-common-ktx:3.1.0")
    kapt("com.google.dagger:hilt-android-compiler:2.37")
    //Retrofit
    implementation( "com.squareup.retrofit2:converter-gson:2.9.0")
    //Okhttp3
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

    androidTestImplementation(projects.platform.testing)
    androidTestImplementation(libs.kodeinAndroid)
    androidTestImplementation(libs.bundles.android.testing)
    androidTestImplementation(libs.bundles.unit.testing)

}