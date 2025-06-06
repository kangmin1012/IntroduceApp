plugins {
    alias(libs.plugins.introduce.android.library)
    alias(libs.plugins.introduce.network)
}

android {
    namespace = "kang.mingu.core.network"
}

dependencies {
    implementation(projects.appConfig)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}