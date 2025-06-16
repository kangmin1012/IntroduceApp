import kang.min.gu.convention.findLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class NetworkPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                "implementation"(findLibrary("retrofit.core"))
                "implementation"(findLibrary("retrofit.kotlin.serialization"))
                "implementation"(findLibrary("retrofit.logging.interceptor"))
            }
        }
    }
}