package kang.mingu.data.api

import kang.mingu.data.model.ProfileResponse
import retrofit2.http.GET

internal interface ProfileApi {
    @GET("user")
    suspend fun getProfile(): ProfileResponse
}