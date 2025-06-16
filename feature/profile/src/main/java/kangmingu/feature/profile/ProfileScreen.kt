package kangmingu.feature.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kang.mingu.core.designsystem.component.NetworkImage
import kang.mingu.core.designsystem.theme.IntroduceMySelfTheme
import kang.mingu.core.ui.util.rememberFlowWithLifecycle
import kang.mingu.core.ui.util.showToast
import kangmingu.feature.profile.reducer.ProfileReducer
import kangmingu.feature.profile.viewmodel.ProfileViewModel


@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    val effect = rememberFlowWithLifecycle(viewModel.effect)

    val context = LocalContext.current

    LaunchedEffect(effect) {
        effect.collect {
            when(it) {
                is ProfileReducer.ProfileScreenEffect.ShowToast -> context.showToast(it.message)
            }
        }
    }


    ProfileContent(
        uiState.profileImage
    )
}

@Composable
private fun ProfileContent(
    profileImage: String = ""
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        NetworkImage(
            imageUrl = profileImage,
            modifier = Modifier.size(128.dp).clip(CircleShape),
            placeHolder = painterResource(kang.mingu.core.designsystem.R.drawable.img_profile_placeholder)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileContentPreview() {
    IntroduceMySelfTheme {
        ProfileContent()
    }
}