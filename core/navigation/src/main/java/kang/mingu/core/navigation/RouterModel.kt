package kang.mingu.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route


sealed interface MainTabRoute : Route {

    @Serializable
    data object Profile : MainTabRoute

    @Serializable
    data object Career : MainTabRoute

    @Serializable
    data object Project : MainTabRoute

    @Serializable
    data object Activities : MainTabRoute
}