package com.imrohansoni.nixiui.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth


enum class HighlightStyle {
    NONE, OUTLINED, FILLED, DOT,
}


@Composable
fun Calendar(
    modifier: Modifier = Modifier,
    yearMonth: YearMonth = YearMonth.now(),
    startOfWeek: DayOfWeek = DayOfWeek.MONDAY,
    highlightDates: List<HighlightDate> = listOf(),
    theme: CalendarTheme = CalendarDarkTheme(),
    onDateSelect: (LocalDate) -> Unit = {},
) {
    var currentYearMonth by rememberSaveable { mutableStateOf(yearMonth) }

    val calendarDays = remember(currentYearMonth, startOfWeek) {
        generateCalendarDays(currentYearMonth, startOfWeek)
    }

    val previousMonth = { currentYearMonth = currentYearMonth.minusMonths(1) }
    val nextMonth = { currentYearMonth = currentYearMonth.plusMonths(1) }

    val defaultRoundedCorner = RoundedCornerShape(12.dp)

    val onSelectToday: () -> Unit = {
        val today = LocalDate.now()
        currentYearMonth = YearMonth.of(today.year, today.monthValue)
    }

    Box(
        modifier
            .fillMaxWidth()
            .background(theme.backgroundColor, defaultRoundedCorner)
            .clip(defaultRoundedCorner)
    ) {
        Column {
            CalendarHeader(theme.primaryColor, currentYearMonth, previousMonth, nextMonth)
            CalendarActionsRow(
                primaryColor = theme.primaryColor,
                currentYearMonth = currentYearMonth,
                onSelectToday = onSelectToday,
                onSelectMonth = {},
                onSelectYear = {})
            CalendarWeekdayRow(startOfWeek = startOfWeek, textColor = theme.primaryTextColor)
            CalendarMonthGrid(
                calendarDays = calendarDays,
                highlightDates = highlightDates,
                theme = theme,
                onDateSelect = { onDateSelect.invoke(it) })
        }
    }
}



