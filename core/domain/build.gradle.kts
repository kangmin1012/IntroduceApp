plugins {
    alias(libs.plugins.introduce.android.library)
}

android {
    namespace = "kang.mingu.core.domain"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(projects.core.data)
    implementation(projects.core.model)
}