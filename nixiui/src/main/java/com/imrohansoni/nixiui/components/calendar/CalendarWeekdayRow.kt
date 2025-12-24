package com.imrohansoni.nixiui.components.calendar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.DayOfWeek

private fun getWeekDays(startOfWeek: DayOfWeek): List<String> {
    val weekdays = if (startOfWeek == DayOfWeek.MONDAY)
        listOf("mo", "tu", "we", "th", "fr", "sa", "su")
    else {
        listOf("su", "mo", "tu", "we", "th", "fr", "sa")
    }
    return weekdays
}

@Composable
fun CalendarWeekdayRow(startOfWeek: DayOfWeek, textColor: Color) {
    val weekdays = remember(startOfWeek) {
        getWeekDays(startOfWeek)
    }

    Row(Modifier.fillMaxWidth()) {
        weekdays.forEach {
            Box(
                Modifier
                    .weight(1f)
                    .height(40.dp),
                contentAlignment = Alignment.Center
            ) {
                BasicText(
                    text = it.uppercase(),
                    style = TextStyle(
                        color = textColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}
