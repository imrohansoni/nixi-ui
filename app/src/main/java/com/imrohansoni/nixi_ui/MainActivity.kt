package com.imrohansoni.nixi_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.imrohansoni.nixiui.components.calendar.Calendar
import com.imrohansoni.nixiui.components.calendar.CalendarDarkTheme
import com.imrohansoni.nixiui.components.calendar.CalendarLightTheme
import com.imrohansoni.nixiui.components.calendar.HighlightDate
import com.imrohansoni.nixiui.components.calendar.HighlightStyle
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val highlightDay = HighlightDate(date = LocalDate.parse("2025-12-20"), HighlightStyle.OUTLINED)
        val highlightDay2 = HighlightDate(date = LocalDate.parse("2026-01-10"), HighlightStyle.FILLED)
        val highlightDay3 = HighlightDate(date = LocalDate.parse("2025-11-11"), HighlightStyle.OUTLINED)
        val highlightDay4 = HighlightDate(date = LocalDate.parse("2025-11-20"), HighlightStyle.OUTLINED)

        setContent {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .padding(top = 36.dp, start = 12.dp, end = 12.dp)
            ) {

                Column{
                    Calendar(
                        startOfWeek = DayOfWeek.MONDAY,
                        yearMonth = YearMonth.of(2025, 11),
                        theme = CalendarDarkTheme(),
                        highlightDates = listOf(highlightDay, highlightDay2, highlightDay3, highlightDay4),
                        onDateSelect = {}
                    )

                    Calendar(
                        startOfWeek = DayOfWeek.MONDAY,
                        yearMonth = YearMonth.of(2025, 11),
                        theme = CalendarLightTheme(),
                        highlightDates = listOf(highlightDay, highlightDay2, highlightDay3, highlightDay4),
                        onDateSelect = {}
                    )
                }

            }
        }
    }
}
