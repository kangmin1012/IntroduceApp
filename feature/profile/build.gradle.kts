plugins {
    alias(libs.plugins.introduce.android.feature)
    alias(libs.plugins.introduce.android.library.compose)
    alias(libs.plugins.introduce.hilt.android)
}

android {
    namespace = "kangmingu.feature.profile"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}