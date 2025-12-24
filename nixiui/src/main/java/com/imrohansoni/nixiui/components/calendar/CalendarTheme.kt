package com.imrohansoni.nixiui.components.calendar

import androidx.compose.ui.graphics.Color

interface CalendarTheme {
    var primaryColor: Color
    var primaryDarkColor: Color
    val primaryLightColor: Color

    val backgroundColor : Color
    val primaryTextColor: Color
    val secondaryTextColor: Color
}

data class CalendarLightTheme(
    override var primaryColor: Color = Color(0xFF007C71),
    override var primaryDarkColor: Color = Color(0xFF004E48),
    override val primaryLightColor: Color = Color(0xFF00CEBE),
    override val primaryTextColor: Color = Color(0xFF141414),
    override val secondaryTextColor: Color = Color(0xFF555555),
    override val backgroundColor: Color = Color(0xFFFFFFFF)
) : CalendarTheme

data class CalendarDarkTheme(
    override var primaryColor: Color = Color(0xFFE91E63),
    override var primaryDarkColor: Color = Color(0xFF9C063B),
    override val primaryLightColor: Color = Color(0xFFFC4581),
    override val primaryTextColor: Color = Color(0xFFE9E9E9),
    override val secondaryTextColor: Color = Color(0xFF6E6E6E),
    override val backgroundColor: Color = Color(0xFF1F1F1F)

) : CalendarTheme