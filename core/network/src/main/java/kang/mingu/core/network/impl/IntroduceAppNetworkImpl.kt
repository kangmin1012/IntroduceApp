package kang.mingu.core.network.impl

import kang.mingu.core.network.IntroduceAppNetwork
import retrofit2.Retrofit
import javax.inject.Inject


class IntroduceAppNetworkImpl @Inject constructor(
    private val retrofit: Retrofit.Builder
) : IntroduceAppNetwork {
    override fun <T> create(baseUrl: String, service: Class<T>): T {
        return retrofit
            .baseUrl(baseUrl)
            .build()
            .create(service)
    }
}