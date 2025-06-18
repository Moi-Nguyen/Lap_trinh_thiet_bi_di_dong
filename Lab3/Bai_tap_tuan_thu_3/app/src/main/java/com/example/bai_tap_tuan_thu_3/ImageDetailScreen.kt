package com.example.bai_tap_tuan_thu_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ImageDetailScreen(
    navController: NavHostController,
    topPadding: Dp = 55.dp,
    horizontalPadding: Dp = 16.dp
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding, vertical = topPadding),
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
                text = "Images",
                fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(36.dp)) // Cân bằng khoảng trống bên phải
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_gtvt),
                    contentDescription = "Image 1",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "https://giaothongvantaitphcm.edu.vn/wp-content/uploads/2025/01/Logo-GTVT.png",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 8.dp, bottom = 24.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.uthi_sadpt),
                    contentDescription = "Image 2",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "In app",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}
