package kang.mingu.core.domain.profile.usecase

import dagger.hilt.android.scopes.ViewModelScoped
import kang.mingu.core.model.profile.Profile
import kang.mingu.data.repository.ProfileRepository
import javax.inject.Inject

@ViewModelScoped
class GetProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(): Result<Profile> = runCatching { profileRepository.getProfile() }
}