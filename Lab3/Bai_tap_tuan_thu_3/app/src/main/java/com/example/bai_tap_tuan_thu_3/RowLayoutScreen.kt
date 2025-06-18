package com.example.bai_tap_tuan_thu_3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp

@Composable
fun TopBarRowLayout(
    navController: NavHostController,
    title: String,
    modifier: Modifier = Modifier,
    horizontalPadding: Dp = 16.dp,
    verticalPadding: Dp = 12.dp
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding, vertical = verticalPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.vector),
            contentDescription = "Back",
            modifier = Modifier
                .size(36.dp)
                .clickable {
                    navController.navigate("ui_components") {
                        popUpTo("ui_components") { inclusive = false }
                    }
                }
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.align(Alignment.CenterVertically),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        Spacer(modifier = Modifier.width(36.dp)) // giữ khoảng trống cân bằng
    }
}

@Composable
fun RowLayoutScreen(navController: NavHostController) {
    val darkBlue = Color(0xFF2196F3)
    val lightBlue = Color(0xFFAEC6FF)
    val backgroundLight = Color(0xFFF5F7FF)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 16.dp)
    ) {
        TopBarRowLayout(
            navController = navController,
            title = "Row Layout",
            horizontalPadding = 24.dp,
            verticalPadding = 16.dp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        repeat(4) { // 4 hàng
            Surface(
                color = backgroundLight,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(vertical = 16.dp, horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp)
                            .background(color = lightBlue, shape = RoundedCornerShape(12.dp))
                    )
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp)
                            .background(color = darkBlue, shape = RoundedCornerShape(12.dp))
                    )
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp)
                            .background(color = lightBlue, shape = RoundedCornerShape(12.dp))
                    )
                }
            }
        }
    }
}
