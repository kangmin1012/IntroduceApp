package kang.min.gu.convention

import com.android.build.api.dsl.ApplicationExtension
import kang.min.gu.convention.constant.ConfigValue

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

    defaultConfig {
        applicationId = "kang.min.gu.introducemyself"
        targetSdk = ConfigValue.TARGET_SDK
        versionCode = ConfigValue.VERSION_CODE
        versionName = ConfigValue.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}