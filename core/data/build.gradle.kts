plugins {
    alias(libs.plugins.introduce.android.library)
}

android {
    namespace = "kang.mingu.data"
}

dependencies {
    implementation(projects.core.network)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}