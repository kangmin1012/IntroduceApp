package kang.mingu.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponse(
    val profileUrl: String = ""
)
