package kang.mingu.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kang.mingu.appconfig.IntroduceAppBuildConfig
import kang.mingu.core.network.IntroduceAppNetwork
import kang.mingu.core.network.create
import kang.mingu.data.api.ProfileApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {

    @Provides
    @Singleton
    fun provideProfileGithubApi(
        introduceAppNetwork: IntroduceAppNetwork,
        introduceAppBuildConfig: IntroduceAppBuildConfig
    ): ProfileApi =
        introduceAppNetwork.create(baseUrl = introduceAppBuildConfig.githubUrl)
}