package com.imrohansoni.nixiui.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import java.time.YearMonth

@Composable
fun CalendarActionsRow(
    primaryColor: Color,
    currentYearMonth: YearMonth,
    onSelectToday: () -> Unit,
    onSelectMonth: () -> Unit,
    onSelectYear: () -> Unit
) {
    Row(Modifier.padding(start = 12.dp, top = 12.dp)) {
        Box(
            Modifier
                .background(primaryColor, RoundedCornerShape(16.dp))
                .padding(horizontal = 12.dp, vertical = 6.dp)
                .clickable {
                    onSelectToday.invoke()
                }
        ) {
            BasicText(text = "Today", style = TextStyle(color = Color.White))
        }
        Spacer(Modifier.width(12.dp))
        Box(
            Modifier
                .background(primaryColor, RoundedCornerShape(16.dp))
                .clickable {
                    onSelectMonth.invoke()
                }
                .padding(horizontal = 12.dp, vertical = 6.dp)
        ) {
            BasicText(
                text = currentYearMonth.month.name.lowercase()
                    .replaceFirstChar { it.uppercase() }, style = TextStyle(color = Color.White)
            )
        }

        Spacer(Modifier.width(8.dp))

        Box(
            Modifier
                .background(primaryColor, RoundedCornerShape(16.dp))
                .clickable {
                    onSelectYear.invoke()
                }
                .padding(horizontal = 12.dp, vertical = 6.dp)
        ) {
            BasicText(
                text = currentYearMonth.year.toString(),
                style = TextStyle(color = Color.White)
            )
        }
    }
}