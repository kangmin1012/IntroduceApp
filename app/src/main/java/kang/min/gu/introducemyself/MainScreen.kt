package kang.min.gu.introducemyself

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kang.min.gu.introducemyself.ui.theme.IntroduceMySelfTheme

@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
        }
    }
}

@Composable
@Preview
private fun MainScreenPreview() {
    IntroduceMySelfTheme {
        MainScreen()
    }
}