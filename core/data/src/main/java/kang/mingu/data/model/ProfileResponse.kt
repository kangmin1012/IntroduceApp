package kang.mingu.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponse(
    @SerialName("avatar_url")
    val profileUrl: String = "",
    @SerialName("name")
    val name: String = "",
    @SerialName("bio")
    val bio: String = "",
    @SerialName("company")
    val company: String = "",
    @SerialName("location")
    val location: String = ""
)
