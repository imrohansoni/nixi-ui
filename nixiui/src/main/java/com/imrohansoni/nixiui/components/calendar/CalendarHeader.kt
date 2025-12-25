package com.imrohansoni.nixiui.components.calendar

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imrohansoni.nixiui.R
import com.imrohansoni.nixiui.components.buttons.IconButton
import java.time.YearMonth

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarHeader(
    headerColor: Color,
    currentYearMonth: YearMonth,
    previousMonth: () -> Unit,
    nextMonth: () -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(headerColor)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(iconDrawable = R.drawable.caret_left, onClick = previousMonth)
        BasicText(
            text = "${
                currentYearMonth.month.name.lowercase().replaceFirstChar { it.uppercase() }
            }, ${currentYearMonth.year}", style = TextStyle(color = Color.White, fontSize = 16.sp)
        )
        IconButton(iconDrawable = R.drawable.caret_right, onClick = nextMonth)
    }
}