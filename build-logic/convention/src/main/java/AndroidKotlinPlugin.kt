import kang.min.gu.convention.setJvmTarget
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.dependencies


internal class AndroidKotlinPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply(libs.findPlugin("kotlin.android").get().get().pluginId)
                apply(libs.findPlugin("jetbrains.kotlin.serialization").get().get().pluginId)
            }

            extensions.setJvmTarget()


//            extensions.configure<KaptExtension>("kapt") {
//                correctErrorTypes = true
//            }


            dependencies {
                DependencyUnitValue.run {
                    implementation(libs.findLibrary("androidx.core.ktx").get())
                    implementation(libs.findLibrary("androidx.lifecycle.runtime.ktx").get())
                    implementation(libs.findLibrary("viewmodel.ktx").get())
                    implementation(libs.findBundle("serialization").get())
                }
            }
        }
    }
}
