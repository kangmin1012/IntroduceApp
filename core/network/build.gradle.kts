plugins {
    alias(libs.plugins.introduce.android.library)
    alias(libs.plugins.introduce.network)
    alias(libs.plugins.introduce.hilt.android)
}

android {
    namespace = "kang.mingu.core.network"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}