package com.example.bai_tap_tuan_thu_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bai_tap_tuan_thu_3.StartScreen
import com.example.bai_tap_tuan_thu_3.TextDetailScreen
import com.example.bai_tap_tuan_thu_3.UIComponentsScreen
import com.example.bai_tap_tuan_thu_3.ImageDetailScreen
import com.example.bai_tap_tuan_thu_3.TextFieldScreen
import com.example.bai_tap_tuan_thu_3.RowLayoutScreen
import com.example.bai_tap_tuan_thu_3.ColumnLayoutScreen
import com.example.bai_tap_tuan_thu_3.ui.theme.Bai_tap_tuan_thu_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bai_tap_tuan_thu_3Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "start") {
                    composable("start") { StartScreen(navController) }
                    composable("ui_components") { UIComponentsScreen(navController) }
                    composable("text_detail") { TextDetailScreen(navController) }
                    composable("image_detail") { ImageDetailScreen(navController) }
                    composable("text_field") { TextFieldScreen(navController) }
                    composable("row_layout") { RowLayoutScreen(navController) }
                    composable("column_layout") { ColumnLayoutScreen(navController) }

                }
            }
        }
    }
}
