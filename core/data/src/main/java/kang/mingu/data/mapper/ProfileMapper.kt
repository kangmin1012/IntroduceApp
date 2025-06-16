package kang.mingu.data.mapper

import kang.mingu.core.model.profile.Profile
import kang.mingu.data.model.ProfileResponse

internal fun ProfileResponse.toModel(): Profile {
    return Profile(
        imageUrl = profileUrl,
        name = name
    )
}