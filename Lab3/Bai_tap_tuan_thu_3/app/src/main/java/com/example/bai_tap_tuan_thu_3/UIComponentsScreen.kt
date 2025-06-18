package com.example.bai_tap_tuan_thu_3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController

@Composable
fun UIComponentsScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 30.dp)
    ) {
        Text(
            text = "UI Components List",
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp,
            modifier = Modifier
                .width(204.dp)
                .align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionTitle("Display")

        Item(
            title = "Text",
            description = "Displays text",
            onClick = { navController.navigate("text_detail") }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Item(
            title = "Image",
            description = "Displays an image",
            onClick = { navController.navigate("image_detail") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        SectionTitle("Input")

        Item(
            title = "TextField",
            description = "Input field for text",
            onClick = { navController.navigate("text_field") }
        )
        Spacer(modifier = Modifier.height(12.dp))
        Item(title = "PasswordField", description = "Input field for passwords")

        Spacer(modifier = Modifier.height(20.dp))

        SectionTitle("Layout")

        Item(
            title = "Column",
            description = "Arranges elements vertically",
            onClick = { navController.navigate("column_layout") }  // Đã thêm navigation cho Column
        )
        Spacer(modifier = Modifier.height(12.dp))
        Item(
            title = "Row",
            description = "Arranges elements horizontally",
            onClick = { navController.navigate("row_layout") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Ô đỏ
        Box(
            modifier = Modifier
                .width(350.dp)
                .background(
                    color = Color(0x4DE80400), // 30% opacity đỏ
                    shape = MaterialTheme.shapes.medium
                )
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Column {
                Text(
                    text = "Tự tìm hiểu",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color(0xFF333333)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Tìm ra tất cả các thành phần UI Cơ bản",
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    color = Color(0xFF333333)
                )
            }
        }
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        color = Color(0xFF333333),
        modifier = Modifier.padding(bottom = 10.dp)
    )
}

@Composable
fun Item(title: String, description: String, onClick: (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .width(350.dp)
            .background(color = Color(0xFFBBDEFB), shape = MaterialTheme.shapes.medium)
            .padding(horizontal = 16.dp, vertical = 14.dp)
            .then(
                if (onClick != null) Modifier.clickable { onClick() }
                else Modifier
            )
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color(0xFF333333)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = description,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            color = Color(0xFF333333)
        )
    }
}
