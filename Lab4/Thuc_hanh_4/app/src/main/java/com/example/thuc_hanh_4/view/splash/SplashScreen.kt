package com.example.thuc_hanh_4.view.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thuc_hanh_4.R
import com.example.thuc_hanh_4.ui.theme.Righteous
import kotlinx.coroutines.delay

val righteousFontFamily = FontFamily(
    Font(R.font.righteous_regular, FontWeight.Normal)
)

@Composable
fun SplashScreen(onTimeout: () -> Unit, delayMillis: Long = 3000L) {
    LaunchedEffect(Unit) {
        delay(delayMillis)
        onTimeout()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.uth_logo),
            contentDescription = null, // nếu không cần screen reader
            modifier = Modifier.size(width = 150.dp, height = 120.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "UTH SmartTasks",
            fontSize = 30.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = Righteous, // nếu đã đưa vào theme
            color = Color(0xFF006EE9),
            textAlign = TextAlign.Center
        )
    }
}

