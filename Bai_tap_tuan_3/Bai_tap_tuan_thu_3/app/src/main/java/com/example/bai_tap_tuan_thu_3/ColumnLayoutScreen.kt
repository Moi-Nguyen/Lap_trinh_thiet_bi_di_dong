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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TopBarColumnLayout(
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

        Spacer(modifier = Modifier.width(36.dp))
    }
}

@Composable
fun ColumnLayoutScreen(navController: NavHostController) {
    val lightGreen = Color(0xFFA9D9BD)
    val darkGreen = Color(0xFF68C88D)
    val backgroundLight = Color(0xFFE8F2E9)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 16.dp)
    ) {
        TopBarColumnLayout(
            navController = navController,
            title = "Colum Layout",
            horizontalPadding = 24.dp,
            verticalPadding = 16.dp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Surface(
            color = backgroundLight,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(color = lightGreen, shape = RoundedCornerShape(16.dp))
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(color = darkGreen, shape = RoundedCornerShape(16.dp))
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(color = lightGreen, shape = RoundedCornerShape(16.dp))
                )
            }
        }
    }
}
