package com.example.bai_tap_tuan_thu_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

@Composable
fun TopBar(
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
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.align(Alignment.CenterVertically),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        Spacer(modifier = Modifier.width(36.dp))
    }
}

@Composable
fun TextFieldScreen(navController: NavHostController) {
    var text by remember { mutableStateOf("") }

    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val view = LocalView.current

    LaunchedEffect(Unit) {
        delay(300)
        focusRequester.requestFocus()
        keyboardController?.show()
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(
            navController = navController,
            title = "TextField",
            horizontalPadding = 24.dp,
            verticalPadding = 20.dp,
            modifier = Modifier.padding(top = 40.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                OutlinedTextField(
                    value = text,
                    onValueChange = { newValue -> text = newValue },
                    placeholder = { Text("Thông tin nhập", fontSize = 18.sp) }, // tăng font placeholder
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp) // tăng chiều cao ô nhập
                        .focusRequester(focusRequester),
                    textStyle = LocalTextStyle.current.copy(fontSize = 18.sp) // tăng font chữ nhập
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = if (text.isBlank()) "Tự động cập nhật dữ liệu theo textfield" else text,
                    color = Color.Red,
                    fontSize = 16.sp, // tăng kích thước chữ đỏ
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

