package com.example.thuc_hanh_4.view.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color = Color(0xFF006EE9),
    unSelectedColor: Color = Color.LightGray,
    dotSize: Dp = 10.dp,
    spacing: Dp = 8.dp
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        repeat(totalDots) { index ->
            val color = if (index == selectedIndex) selectedColor else unSelectedColor
            Box(
                modifier = Modifier
                    .size(dotSize)
                    .clip(CircleShape)
                    .background(color)
            )

            // spacing giữa các dots
            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.width(spacing))
            }
        }
    }
}
