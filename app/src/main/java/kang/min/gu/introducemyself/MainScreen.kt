package kang.min.gu.introducemyself

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
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
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import kang.min.gu.introducemyself.route.MainTab
import kang.mingu.core.designsystem.ui.theme.IntroduceMySelfTheme
import kang.mingu.core.navigation.MainTabRoute
import kangmingu.feature.profile.ProfileScreen

private val bottomNavigationItems = MainTab.entries

@Composable
fun MainScreen() {

    val backstack = remember { mutableStateListOf<Any>(MainTabRoute.Profile)}

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                windowInsets = NavigationBarDefaults.windowInsets
            ) {
                bottomNavigationItems.forEach { item ->
                    NavigationBarItem(
                        selected = backstack.lastOrNull() == item.route,
                        onClick = {
                            backstack.add(item.route)
                            backstack.removeAll { backstackRoute ->
                                backstackRoute != item.route
                            }
                        },
                        icon = {
                            Icon(
                                painterResource(item.iconResId),
                                contentDescription = "바텀내비게이션 아이콘",
                            )
                        },
                        label = {
                            Text(
                               text = item.title
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavDisplay(
             backstack,
            entryDecorators = listOf(
                rememberSavedStateNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            onBack = {
                backstack.removeLastOrNull()
            },
            entryProvider = entryProvider {
                entry<MainTabRoute.Profile> {
                    ProfileScreen()
                }
                entry<MainTabRoute.Career> {

                }
                entry<MainTabRoute.Project> {

                }
                entry<MainTabRoute.Activities> {

                }
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
@Preview
private fun MainScreenPreview() {
    IntroduceMySelfTheme {
        MainScreen()
    }
}