plugins {
    alias(libs.plugins.introduce.android.library)
}

android {
    namespace = "kang.mingu.core.navigation"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}