package kang.min.gu.convention

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureHilt() {
    with(pluginManager) plugin@{
            apply(this@configureHilt.findPlugin("hilt.android").get().pluginId)
            apply(this@configureHilt.findPlugin("ksp").get().pluginId)
    }

    dependencies {
        "implementation"(findLibrary("hilt"))
        "implementation"(findLibrary("hilt.navigation.compose"))
        "ksp"(findLibrary("hilt.compiler"))
    }
}