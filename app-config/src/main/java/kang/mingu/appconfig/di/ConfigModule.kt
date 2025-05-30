package kang.mingu.appconfig.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kang.mingu.appconfig.IntroduceAppBuildConfig
import kang.mingu.appconfig.impl.IntroduceAppBuildConfigImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ConfigModule {
    @Binds
    @Singleton
    abstract fun bindIntroduceAppBuildConfig(
        impl: IntroduceAppBuildConfigImpl
    ): IntroduceAppBuildConfig
}