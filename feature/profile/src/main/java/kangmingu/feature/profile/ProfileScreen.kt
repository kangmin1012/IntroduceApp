package kangmingu.feature.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kang.mingu.core.designsystem.ui.theme.IntroduceMySelfTheme

@Composable
fun ProfileScreen() {
    ProfileContent()
}

@Composable
private fun ProfileContent() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }
}

@Preview
@Composable
private fun ProfileContentPreview() {
    IntroduceMySelfTheme {
        ProfileContent()
    }
}