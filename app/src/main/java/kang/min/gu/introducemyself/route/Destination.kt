package kang.min.gu.introducemyself.route

import androidx.annotation.DrawableRes
import kang.min.gu.introducemyself.R

sealed class MainDestination(val name: String, @DrawableRes val icon: Int) {
    data object Home : MainDestination("프로필", R.drawable.ic_profile)
    data object Career : MainDestination("경력", R.drawable.ic_career)
    data object Project : MainDestination("프로젝트", R.drawable.ic_project)
    data object Activities : MainDestination("활동", R.drawable.ic_activities)
}

