plugins {
    alias(libs.plugins.introduce.android.library)
    alias(libs.plugins.introduce.android.library.compose)
}

android {
    namespace = "kang.mingu.core.ui"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}