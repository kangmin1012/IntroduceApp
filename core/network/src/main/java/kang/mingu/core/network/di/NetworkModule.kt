package kang.mingu.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import kang.mingu.appconfig.BuildConfig
import kang.mingu.appconfig.IntroduceAppBuildConfig
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkhttpClient(
        interceptors: Provider<Set<@JvmSuppressWildcards Interceptor>>,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .apply {
                interceptors.get().forEach { addInterceptor(it) }
            }
            .build()

    @Provides
    @Singleton
    @IntoSet
    fun provideHeaderInterceptor(
        introduceAppNetwork: IntroduceAppBuildConfig
    ): Interceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val newBuilder = chain.request().newBuilder().apply {
                header("Accept", "application/vnd.github+json")
                header("X-GitHub-Api-Version", "2022-11-28")
                header("Authorization", introduceAppNetwork.githubAuthToken)
            }

            return chain.proceed(newBuilder.build())
        }
    }

    @Provides
    @Singleton
    @IntoSet
    fun provideHttpLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideConverterFactory(json: Json): Converter.Factory =
        json.asConverterFactory("application/json".toMediaType())

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit.Builder =
        Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
}