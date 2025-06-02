plugins {
    alias(libs.plugins.introduce.android.library)
    alias(libs.plugins.introduce.network)
}

android {
    namespace = "kang.mingu.data"
}

dependencies {
    implementation(projects.core.network)
    implementation(projects.appConfig)
    implementation(projects.core.model)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}