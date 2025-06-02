import kang.min.gu.convention.constant.DependencyUnitValue.implementation
import kang.min.gu.convention.findBundle
import kang.min.gu.convention.findPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

internal class KotlinLibraryPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) project@{
            with(pluginManager) {
                apply(this@project.findPlugin("jetbrains.kotlin.jvm").get().pluginId)
                apply(this@project.findPlugin("jetbrains.kotlin.serialization").get().pluginId)
            }

            extensions.configure<JavaPluginExtension> {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }


            extensions.configure<KotlinJvmProjectExtension> {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }

            dependencies {
                implementation(findBundle("serialization"))
            }
        }
    }

}