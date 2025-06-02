package kang.mingu.data.model

import kotlinx.serialization.Serializable

@Serializable
internal data class ProfileResponse(
    val profileUrl: String = ""
)
