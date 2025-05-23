plugins {
    alias(libs.plugins.introduce.android.feature)
    alias(libs.plugins.introduce.android.library.compose)
}

android {
    namespace = "kangmingu.feature.profile"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}