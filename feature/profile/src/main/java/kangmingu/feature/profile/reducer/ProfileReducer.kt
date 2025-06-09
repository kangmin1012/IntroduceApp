package kangmingu.feature.profile.reducer

import androidx.compose.runtime.Immutable
import kang.mingu.core.ui.base.Reducer

class ProfileReducer : Reducer<ProfileReducer.ProfileScreenState, ProfileReducer.ProfileScreenEvent, ProfileReducer.ProfileScreenEffect> {
    @Immutable
    data class ProfileScreenState(
        val profileImage: String
    ) : Reducer.ViewState

    sealed interface ProfileScreenEvent : Reducer.ViewEvent {
        data class LoadProfile(val profileImage: String) : ProfileScreenEvent
        data class SendToastMessage(val message: String) : ProfileScreenEvent
    }

    sealed interface ProfileScreenEffect : Reducer.ViewEffect {
        data class ShowToast(val message: String) : ProfileScreenEffect
    }

    override fun reduce(
        previousState: ProfileScreenState,
        event: ProfileScreenEvent
    ): Pair<ProfileScreenState, ProfileScreenEffect?> {
        return when(event) {
            is ProfileScreenEvent.LoadProfile -> {
                ProfileScreenState(profileImage = event.profileImage) to null
            }

            is ProfileScreenEvent.SendToastMessage -> {
                previousState to ProfileScreenEffect.ShowToast(event.message)
            }
        }
    }
}