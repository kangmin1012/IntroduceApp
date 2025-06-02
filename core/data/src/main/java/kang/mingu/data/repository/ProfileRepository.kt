package kang.mingu.data.repository

import kang.mingu.core.model.profile.Profile

interface ProfileRepository {
    suspend fun getProfile(): Profile
}