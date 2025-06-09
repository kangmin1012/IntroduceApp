package kangmingu.feature.profile.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kang.mingu.core.domain.profile.usecase.GetProfileUseCase
import kang.mingu.core.ui.base.BaseViewModel
import kangmingu.feature.profile.reducer.ProfileReducer
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase
) : BaseViewModel<ProfileReducer.ProfileScreenState, ProfileReducer.ProfileScreenEvent, ProfileReducer.ProfileScreenEffect>(
    initialState = ProfileReducer.ProfileScreenState(profileImage = ""),
    reducer = ProfileReducer()
) {

    init {
        getProfile()
    }

    /**
     * 프로필 정보를 가져온다
     */
    private fun getProfile() {
        viewModelScope.launch {
            getProfileUseCase()
                .onSuccess {
                    sendEvent(ProfileReducer.ProfileScreenEvent.LoadProfile(it.imageUrl))
                }.onFailure {
                    sendEvent(ProfileReducer.ProfileScreenEvent.SendToastMessage("프로필 정보를 가져오는데 실패했습니다."))
                }
        }
    }
}