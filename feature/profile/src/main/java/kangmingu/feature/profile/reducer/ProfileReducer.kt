package kangmingu.feature.profile.reducer

import androidx.compose.runtime.Immutable
import kang.mingu.core.ui.base.Reducer

internal class ProfileReducer : Reducer<ProfileReducer.ProfileScreenState, ProfileReducer.ProfileScreenEvent, ProfileReducer.ProfileScreenEffect> {
    @Immutable
    data class ProfileScreenState(
        val profileImage: String
    ) : Reducer.ViewState

    sealed interface ProfileScreenEvent : Reducer.ViewEvent {
        data class LoadProfile(val profileImage: String) : ProfileScreenEvent
    }

    sealed interface ProfileScreenEffect : Reducer.ViewEffect

    override fun reduce(
        previousState: ProfileScreenState,
        event: ProfileScreenEvent
    ): Pair<ProfileScreenState, ProfileScreenEffect?> {
        when(event) {
            is ProfileScreenEvent.LoadProfile -> {
                return ProfileScreenState(profileImage = event.profileImage) to null
            }
        }
    }
}