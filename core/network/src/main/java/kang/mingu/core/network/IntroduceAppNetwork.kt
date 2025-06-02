package kang.mingu.core.network

interface IntroduceAppNetwork {
    fun <T> create(baseUrl: String, service: Class<T>): T
}

inline fun <reified T> IntroduceAppNetwork.create(baseUrl: String): T {
    return create(baseUrl, T::class.java)
}