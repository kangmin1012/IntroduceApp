import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.introduce.android.library)
}

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")

if (localPropertiesFile.exists()) {
    localProperties.load(FileInputStream(localPropertiesFile))
}

val githubToken: String? = localProperties.getProperty("github.token")

android {
    namespace = "kang.mingu.appconfig"


    buildFeatures {
        buildConfig = true
    }


    defaultConfig {
        buildConfigField("String", "GITHUB_TOKEN", "\"$githubToken\"")
    }
}