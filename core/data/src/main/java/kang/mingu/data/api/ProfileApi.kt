package kang.mingu.data.api

import kang.mingu.data.model.ProfileResponse
import retrofit2.http.GET

interface ProfileApi {
    @GET("user")
    suspend fun getProfile(): ProfileResponse
}