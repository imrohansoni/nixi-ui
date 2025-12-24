package com.imrohansoni.nixiui.components.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconDrawable: Int,
    onClick: () -> Unit
) {
    Box(
        modifier
            .size(30.dp)
            .background(Color.Transparent, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
            .clickable {
                onClick.invoke()
            },
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(iconDrawable), contentDescription = null)
    }
}