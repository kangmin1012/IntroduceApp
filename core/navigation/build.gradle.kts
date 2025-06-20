plugins {
    alias(libs.plugins.introduce.android.library)
}

android {
    namespace = "kang.mingu.core.navigation"
}

dependencies {
    implementation(libs.bundles.navigation3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}