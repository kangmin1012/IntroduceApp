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

        register("androidLibraryCompose") {
            id = libs.plugins.introduce.android.library.compose.get().pluginId
            implementationClass = "AndroidLibraryComposePlugin"
        }

        register("androidKotlin") {
            id = libs.plugins.introduce.android.kotlin.get().pluginId
            implementationClass = "AndroidKotlinPlugin"
        }

        register("koin") {
            id = libs.plugins.introduce.koin.get().pluginId
            implementationClass = "KoinPlugin"
        }
    }
}