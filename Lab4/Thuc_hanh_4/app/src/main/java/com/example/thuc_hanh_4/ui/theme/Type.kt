package com.example.thuc_hanh_4.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thuc_hanh_4.R

// FontFamily custom
val Righteous = FontFamily(
    Font(R.font.righteous_regular, FontWeight.Normal)
)

// Typography mặc định + override
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = Righteous,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    )
)
