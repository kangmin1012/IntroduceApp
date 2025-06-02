package kang.mingu.data.repository.impl

import kang.mingu.core.model.profile.Profile
import kang.mingu.data.api.ProfileApi
import kang.mingu.data.mapper.toModel
import kang.mingu.data.repository.ProfileRepository
import javax.inject.Inject

internal class ProfileRepositoryImpl @Inject constructor(
    val profileApi: ProfileApi
) : ProfileRepository {

    override suspend fun getProfile(): Profile {
        return profileApi.getProfile().toModel()
    }
}