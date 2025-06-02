package kang.mingu.appconfig.impl

import kang.mingu.appconfig.BuildConfig
import kang.mingu.appconfig.IntroduceAppBuildConfig
import javax.inject.Inject

class IntroduceAppBuildConfigImpl @Inject constructor() : IntroduceAppBuildConfig {
    override val githubUrl: String
        get() = "https://api.github.com"
    override val githubAuthToken: String
        get() = "Bearer ${BuildConfig.GITHUB_TOKEN}"
}