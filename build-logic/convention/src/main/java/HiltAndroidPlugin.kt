import kang.min.gu.convention.findLibrary
import kang.min.gu.convention.findPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class HiltAndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) project@{
            with(pluginManager) {
                apply(this@project.findPlugin("hilt.android").get().pluginId)
                apply(this@project.findPlugin("ksp").get().pluginId)
            }

            dependencies {
                "implementation"(findLibrary("hilt"))
                "ksp"(findLibrary("hilt.compiler"))
            }
        }
    }
}