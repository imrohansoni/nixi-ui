package com.imrohansoni.nixiui.components.calendar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import java.time.LocalDate

@Composable
fun CalendarMonthGrid(
    theme: CalendarTheme,
    calendarDays: List<CalendarDate>,
    highlightDates: List<HighlightDate>,
    onDateSelect: (LocalDate) -> Unit,
) {
    val highlightMap = remember(highlightDates) {
        highlightDates.associateBy { it.date }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(7),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(calendarDays.size) { index ->
            val day = calendarDays[index]
            val highlightStyle = highlightMap[day.date]?.style ?: HighlightStyle.NONE

            CalendarDayCell(
                calendarDate = day,
                highlightStyle = highlightStyle,
                onDateSelect = onDateSelect,
                primaryTextColor = theme.primaryTextColor,
                secondaryTextColor = theme.secondaryTextColor,
                highlightColor = theme.primaryColor
            )
        }
    }
}