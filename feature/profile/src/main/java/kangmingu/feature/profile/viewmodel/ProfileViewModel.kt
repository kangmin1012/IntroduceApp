package kangmingu.feature.profile.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kang.mingu.core.ui.base.BaseViewModel
import kangmingu.feature.profile.reducer.ProfileReducer
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
internal class ProfileViewModel @Inject constructor() : BaseViewModel<ProfileReducer.ProfileScreenState, ProfileReducer.ProfileScreenEvent, ProfileReducer.ProfileScreenEffect>(
    initialState = ProfileReducer.ProfileScreenState(profileImage = ""),
    reducer = ProfileReducer()
) {

    init {
        getProfile()
    }


    fun getProfile() {
        viewModelScope.launch {
            // TODO : 프로필 정보를 가져온다
        }
    }
}