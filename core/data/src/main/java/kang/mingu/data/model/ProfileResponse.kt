package kang.mingu.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponse(
    @SerialName("avatar_url")
    val profileUrl: String = ""
)
