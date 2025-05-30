package kang.mingu.core.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kang.mingu.core.network.IntroduceAppNetwork
import kang.mingu.core.network.impl.IntroduceAppNetworkImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class IntroduceAppNetworkModule {

    @Binds
    @Singleton
    abstract fun bindIntroduceAppNetwork(
        impl: IntroduceAppNetworkImpl
    ): IntroduceAppNetwork
}