package kang.min.gu.introducemyself

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kang.mingu.core.designsystem.ui.theme.IntroduceMySelfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroduceMySelfTheme {
                MainScreen()
            }
        }
    }
}