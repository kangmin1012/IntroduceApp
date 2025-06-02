package kang.mingu.data.repository

interface ProfileRepository {
    suspend fun getProfile()
}