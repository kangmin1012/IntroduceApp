plugins {
    alias(libs.plugins.introduce.android.application)
    alias(libs.plugins.introduce.android.application.compose)
    alias(libs.plugins.introduce.android.kotlin)
    alias(libs.plugins.introduce.koin)
}

android {
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
}