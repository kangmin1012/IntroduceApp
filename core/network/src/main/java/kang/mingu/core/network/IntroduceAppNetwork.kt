package kang.mingu.core.network

interface IntroduceAppNetwork {
    fun <T> create(baseUrl: String, service: Class<T>): T
}