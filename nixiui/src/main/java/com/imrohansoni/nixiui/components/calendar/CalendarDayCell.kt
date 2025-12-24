package com.imrohansoni.nixiui.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@Composable
fun CalendarDayCell(
    modifier: Modifier = Modifier,
    calendarDate: CalendarDate,
    highlightStyle: HighlightStyle,
    highlightColor: Color,
    primaryTextColor: Color,
    secondaryTextColor: Color,
    onDateSelect: (LocalDate) -> Unit
) {
    Box(
        modifier
            .height(40.dp)
            .padding(2.dp)
            .background(
                if (highlightStyle == HighlightStyle.FILLED) highlightColor else Color.Transparent,
                RoundedCornerShape(12.dp)
            )
            .border(
                2.dp,
                if (highlightStyle == HighlightStyle.OUTLINED) highlightColor else Color.Transparent,
                RoundedCornerShape(12.dp)
            )
            .clickable {
                onDateSelect.invoke(calendarDate.date)
            }, contentAlignment = Alignment.Center
    ) {
        val textColor = if (calendarDate.dateType == DateType.CURRENT) {
            primaryTextColor
        } else {
            secondaryTextColor
        }

        if (highlightStyle == HighlightStyle.DOT) {
            Box(
                Modifier
                    .size(8.dp)
                    .background(highlightColor, CircleShape)
                    .align(Alignment.TopEnd)
            ) {}
        }

        BasicText(
            text = "${calendarDate.date.dayOfMonth}",
            style = TextStyle(color = if (highlightStyle == HighlightStyle.FILLED) Color.White else textColor)
        )
    }
}