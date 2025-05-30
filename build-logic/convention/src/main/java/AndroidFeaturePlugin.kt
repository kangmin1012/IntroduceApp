import com.android.build.api.dsl.LibraryExtension
import kang.min.gu.convention.configBasicOption
import kang.min.gu.convention.constant.ConfigValue
import kang.min.gu.convention.constant.DependencyUnitValue
import kang.min.gu.convention.setJvmTarget
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies


internal class AndroidFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply(libs.findPlugin("android.library").get().get().pluginId)
                apply(libs.findPlugin("introduce.android.kotlin").get().get().pluginId)
            }


            extensions.configure<LibraryExtension> {
                compileSdk = ConfigValue.TARGET_SDK

                defaultConfig {
                    minSdk = ConfigValue.MIN_SDK

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                buildTypes {
                    release {
                        isMinifyEnabled = false
                    }
                }

                configBasicOption()
            }

            extensions.setJvmTarget()

            dependencies {
                DependencyUnitValue.run {
                    implementation(project(":core:designsystem"))
                    implementation(project(":core:navigation"))
                }
            }
        }
    }
}