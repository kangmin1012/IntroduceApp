package kang.mingu.core.designsystem.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import kang.mingu.core.designsystem.R

private val BaseTypography = Typography()

private val pretendardFamily = FontFamily(
    Font(R.font.pretendard_extra_light, FontWeight.ExtraLight),
    Font(R.font.pretendard_light, FontWeight.Light),
    Font(R.font.pretendard_regular, FontWeight.Normal),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_semi_bold, FontWeight.SemiBold),
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_extra_bold, FontWeight.ExtraBold),
    Font(R.font.pretendard_black, FontWeight.Black),
    Font(R.font.pretendard_thin, FontWeight.Thin)
)

val PretendardTypography = Typography(
    displayLarge = BaseTypography.displayLarge.copy(fontFamily = pretendardFamily),
    displayMedium = BaseTypography.displayMedium.copy(fontFamily = pretendardFamily),
    displaySmall = BaseTypography.displaySmall.copy(fontFamily = pretendardFamily),
    headlineLarge = BaseTypography.headlineLarge.copy(fontFamily = pretendardFamily),
    headlineMedium = BaseTypography.headlineMedium.copy(fontFamily = pretendardFamily),
    headlineSmall = BaseTypography.headlineSmall.copy(fontFamily = pretendardFamily),
    titleLarge = BaseTypography.titleLarge.copy(fontFamily = pretendardFamily),
    titleMedium = BaseTypography.titleMedium.copy(fontFamily = pretendardFamily),
    titleSmall = BaseTypography.titleSmall.copy(fontFamily = pretendardFamily),
    bodyLarge = BaseTypography.bodyLarge.copy(fontFamily = pretendardFamily),
    bodyMedium = BaseTypography.bodyMedium.copy(fontFamily = pretendardFamily),
    bodySmall = BaseTypography.bodySmall.copy(fontFamily = pretendardFamily),
    labelLarge = BaseTypography.labelLarge.copy(fontFamily = pretendardFamily),
    labelMedium = BaseTypography.labelMedium.copy(fontFamily = pretendardFamily),
    labelSmall = BaseTypography.labelSmall.copy(fontFamily = pretendardFamily),
)
