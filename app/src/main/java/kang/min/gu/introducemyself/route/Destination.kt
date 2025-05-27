package kang.min.gu.introducemyself.route

import androidx.annotation.DrawableRes
import kang.min.gu.introducemyself.R
import kang.mingu.core.navigation.MainTabRoute

internal enum class MainTab(
    @DrawableRes val iconResId: Int,
    internal val title: String,
    val route: MainTabRoute,
) {
    PROFILE(
        iconResId = R.drawable.ic_profile,
        title = "프로필",
        route = MainTabRoute.Profile,
    ),
    CAREER(
        iconResId = R.drawable.ic_career,
        title = "경력",
        route = MainTabRoute.Career,
    ),
    PROJECT(
        iconResId = R.drawable.ic_project,
        title = "프로젝트",
        route = MainTabRoute.Project,
    ),
    ACTIVITIES(
        iconResId = R.drawable.ic_activities,
        title = "활동",
        route = MainTabRoute.Activities,
    );
}