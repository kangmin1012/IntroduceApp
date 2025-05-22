package kang.min.gu.introducemyself

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import kang.min.gu.introducemyself.route.MainDestination.Activities
import kang.min.gu.introducemyself.route.MainDestination.Career
import kang.min.gu.introducemyself.route.MainDestination.Home
import kang.min.gu.introducemyself.route.MainDestination.Project
import kang.min.gu.introducemyself.ui.theme.IntroduceMySelfTheme

private val bottomNavigationItems = listOf(Home, Career, Project, Activities)

@Composable
fun MainScreen() {

    val backstack = remember { mutableStateListOf<Any>(Home)}

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                windowInsets = NavigationBarDefaults.windowInsets
            ) {
                bottomNavigationItems.forEach { item ->
                    NavigationBarItem(
                        selected = backstack.lastOrNull() == item,
                        onClick = {
                            backstack.add(item)
                        },
                        icon = {
                            Icon(
                                painterResource(item.icon),
                                contentDescription = "바텀내비게이션 아이콘",
                            )
                        },
                        label = {
                            Text(
                               text = item.name
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
//        NavDisplay(
//            backstack,
//            onBack = { backstack.removeLastOrNull() },
//            entryProvider = entryProvider {
//                entry<Home> {  }
//                entry<Career> {  }
//                entry<Project> {  }
//                entry<Activities> { }
//            },
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding)
//        )
    }
}

@Composable
@Preview
private fun MainScreenPreview() {
    IntroduceMySelfTheme {
        MainScreen()
    }
}