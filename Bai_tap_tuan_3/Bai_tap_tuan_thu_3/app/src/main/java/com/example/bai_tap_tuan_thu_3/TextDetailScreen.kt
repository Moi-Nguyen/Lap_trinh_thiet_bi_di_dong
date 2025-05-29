package com.example.bai_tap_tuan_thu_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TextDetailScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        // Nút back nằm ở góc trái trên
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.vector),
                contentDescription = "Back",
                modifier = Modifier
                    .size(36.dp)
                    .clickable { navController.navigate("ui_components") }
            )
            Spacer(modifier = Modifier.weight(1f)) // Đẩy icon về trái
        }

        Spacer(modifier = Modifier.height(5.dp))

        // Tiêu đề căn giữa ngang toàn màn hình
        Text(
            text = "Text Detail",
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(15.dp))

        // Nội dung text căn giữa ngang dọc màn hình
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "The ", fontSize = 30.sp, color = Color.Black)
                    Text(
                        text = "quick ",
                        fontSize = 30.sp,
                        color = Color.Black,
                        textDecoration = TextDecoration.LineThrough
                    )
                    Text(
                        text = "Brown",
                        fontSize = 32.sp,
                        color = Color(0xFFA5651C)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "fox j u m p s ", fontSize = 30.sp, color = Color.Black)
                    Text(
                        text = "over",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "the ",
                        fontSize = 30.sp,
                        color = Color.Black,
                        textDecoration = TextDecoration.Underline
                    )
                    Text(
                        text = "lazy ",
                        fontSize = 30.sp,
                        color = Color.Black,
                        fontStyle = FontStyle.Italic
                    )
                    Text(text = "dog.", fontSize = 30.sp, color = Color.Black)
                }
            }
        }
    }
}

