import com.android.build.api.dsl.ApplicationExtension
import kang.min.gu.convention.configBasicOption
import kang.min.gu.convention.configureApplicationBuildType
import kang.min.gu.convention.configureApplicationDefault
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

internal class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply(libs.findPlugin("android.application").get().get().pluginId)
                apply(libs.findPlugin("introduce.android.kotlin").get().get().pluginId)
                apply(libs.findPlugin("introduce.koin").get().get().pluginId)
            }

            extensions.configure<ApplicationExtension> {
                configureApplicationDefault()
                configureApplicationBuildType()
                configBasicOption()
            }
        }
    }
}