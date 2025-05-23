package kang.min.gu.convention

import DependencyUnitValue
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

//        buildFeatures {
//            compose = true
//        }

        extensions.getByType<ComposeCompilerGradlePluginExtension>().apply {
            includeSourceInformation.set(true)

//            reportsDestination.set(
//                layout.buildDirectory.dir("compose_compiler")
//            )
        }

        dependencies {
            DependencyUnitValue.run {
                val composeBom = platform(libs.findLibrary("androidx.compose.bom").get())
                implementation(composeBom)
                implementation(libs.findLibrary("androidx.activity.compose").get())
                implementation(libs.findLibrary("androidx.ui").get())
                implementation(libs.findLibrary("androidx.ui.graphics").get())
                implementation(libs.findLibrary("androidx.ui.tooling.preview").get())
                implementation(libs.findLibrary("androidx.material3").get())
                implementation(libs.findBundle("navigation3").get())

                androidTestImplementation(composeBom)
                debugImplementation(libs.findLibrary("androidx.ui.tooling").get())
                debugImplementation(libs.findLibrary("androidx.ui.test.manifest").get())
            }
        }
    }
}