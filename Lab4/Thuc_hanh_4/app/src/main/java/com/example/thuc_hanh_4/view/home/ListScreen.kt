package com.example.thuc_hanh_4.view.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thuc_hanh_4.R
import com.example.thuc_hanh_4.model.Task
import kotlin.math.absoluteValue
import androidx.compose.material.icons.filled.Add
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    tasks: List<Task> = sampleTasks,
    onAddClick: () -> Unit
) {
    Scaffold(
        containerColor = Color(0xFFF8F8FC),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("List", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFFB3E5FC), // Nền xanh nhạt
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White,
                                modifier = Modifier.padding(6.dp)
                            )
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddClick,
                containerColor = Color(0xFF2196F3)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(tasks) { task ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = randomSoftColor(task.title)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(task.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(task.description, fontSize = 14.sp, color = Color.DarkGray)
                        }
                    }
                }
            }
        }
    }
}

fun randomSoftColor(key: String): Color {
    val colors = listOf(
        Color(0xFFBBDEFB), // blue
        Color(0xFFFFCDD2), // red
        Color(0xFFC8E6C9), // green
        Color(0xFFFFF9C4)  // yellow
    )
    return colors[key.hashCode().absoluteValue % colors.size]
}

val sampleTasks = listOf(
    Task("Complete Android Project", "Finish the UI, integrate API, and write documentation"),
    Task("Submit Assignment", "Push final commit to GitHub and submit link"),
    Task("Review Kotlin", "Study data classes, coroutines, and Jetpack Compose basics"),
    Task("Design UI", "Create wireframes and color palette for upcoming screen")
)
