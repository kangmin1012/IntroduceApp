package kang.min.gu.convention

import com.android.build.api.dsl.ApplicationExtension

internal fun ApplicationExtension.configureApplicationBuildType() {
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

internal fun ApplicationExtension.configureApplicationDefault() {
    namespace = "kang.min.gu.introducemyself"
    compileSdk = 36

    defaultConfig {
        applicationId = "kang.min.gu.introducemyself"
        minSdk = 27
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}