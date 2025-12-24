package com.imrohansoni.nixiui.components.calendar

import java.time.LocalDate
import java.time.YearMonth
import java.time.DayOfWeek

enum class DateType { PREVIOUS, CURRENT, NEXT }

data class HighlightDate(
    val date: LocalDate,
    val style: HighlightStyle = HighlightStyle.OUTLINED
)

data class CalendarDate(
    val date: LocalDate,
    val dateType: DateType,
)

fun generateCalendarDays(
    yearMonth: YearMonth,
    startOfWeek: DayOfWeek = DayOfWeek.MONDAY
): List<CalendarDate> {

    val currentMonth = YearMonth.of(yearMonth.year, yearMonth.month)
    val previousMonth = currentMonth.minusMonths(1)
    val nextMonth = currentMonth.plusMonths(1)

    val firstDayOfCurrentMonth = currentMonth.atDay(1)

    // Offset for first day
    val startOffset =
        (firstDayOfCurrentMonth.dayOfWeek.value - startOfWeek.value + 7) % 7

    val dates = mutableListOf<CalendarDate>()

    // 1️⃣ Previous month overflow days
    val previousMonthLastDay = previousMonth.lengthOfMonth()
    for (i in startOffset downTo 1) {
        dates.add(
            CalendarDate(
                date = previousMonth.atDay(previousMonthLastDay - i + 1),
                dateType = DateType.PREVIOUS
            )
        )
    }

    // 2️⃣ Current month days
    for (day in 1..currentMonth.lengthOfMonth()) {
        dates.add(
            CalendarDate(
                date = currentMonth.atDay(day),
                dateType = DateType.CURRENT
            )
        )
    }

    // 3️⃣ Next month overflow days (to complete the grid)
    val remainingCells = (7 - dates.size % 7) % 7
    for (day in 1..remainingCells) {
        dates.add(
            CalendarDate(
                date = nextMonth.atDay(day),
                dateType = DateType.NEXT
            )
        )
    }
    return dates
}