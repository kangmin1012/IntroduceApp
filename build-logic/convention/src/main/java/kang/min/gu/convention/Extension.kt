package kang.min.gu.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType
import org.gradle.plugin.use.PluginDependency

private val ExtensionContainer.libs: VersionCatalog
    get() = getByType<VersionCatalogsExtension>().named("libs")

internal fun Project.findLibrary(name: String): Provider<MinimalExternalModuleDependency> = extensions.libs.findLibrary(name).get()

internal fun Project.findPlugin(name: String): Provider<PluginDependency> = extensions.libs.findPlugin(name).get()