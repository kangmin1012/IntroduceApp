plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.compose.compiler.extension)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.introduce.android.application.asProvider().get().pluginId
            implementationClass = "AndroidApplicationPlugin"
        }

        register("androidApplicationCompose") {
            id = libs.plugins.introduce.android.application.compose.get().pluginId
            implementationClass = "AndroidApplicationComposePlugin"
        }

        register("androidFeature") {
            id = libs.plugins.introduce.android.feature.get().pluginId
            implementationClass = "AndroidFeaturePlugin"
        }

        register("androidLibrary") {
            id = libs.plugins.introduce.android.library.asProvider().get().pluginId
            implementationClass = "AndroidLibraryPlugin"
        }

        register("androidLibraryCompose") {
            id = libs.plugins.introduce.android.library.compose.get().pluginId
            implementationClass = "AndroidLibraryComposePlugin"
        }

        register("androidKotlin") {
            id = libs.plugins.introduce.android.kotlin.get().pluginId
            implementationClass = "AndroidKotlinPlugin"
        }

        register("hiltAndroid") {
            id = libs.plugins.introduce.hilt.android.get().pluginId
            implementationClass = "HiltAndroidPlugin"
        }

        register("hiltKotlin") {
            id = libs.plugins.introduce.hilt.kotlin.get().pluginId
            implementationClass = "HiltKotlinPlugin"
        }

        register("network") {
            id = libs.plugins.introduce.network.get().pluginId
            implementationClass = "NetworkPlugin"
        }
    }
}