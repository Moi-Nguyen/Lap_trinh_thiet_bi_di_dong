package com.example.thuc_hanh_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thuc_hanh_4.model.Task
import com.example.thuc_hanh_4.ui.theme.Thuc_hanh_4Theme
import com.example.thuc_hanh_4.view.home.AddTaskScreen
import com.example.thuc_hanh_4.view.home.ListScreen
import com.example.thuc_hanh_4.view.onboarding.OnboardingPagerScreen
import com.example.thuc_hanh_4.view.splash.SplashScreen
import com.example.thuc_hanh_4.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Thuc_hanh_4Theme {
                val taskViewModel: TaskViewModel = viewModel()
                var showSplash by remember { mutableStateOf(true) }
                var showMainScreen by remember { mutableStateOf(false) }
                var showAddScreen by remember { mutableStateOf(false) }

                when {
                    showSplash -> SplashScreen(onTimeout = { showSplash = false })

                    showMainScreen -> {
                        if (showAddScreen) {
                            AddTaskScreen(
                                onAdd = {
                                    taskViewModel.addTask(it)
                                    showAddScreen = false
                                },
                                onBack = { showAddScreen = false }
                            )
                        } else {
                            ListScreen(
                                tasks = taskViewModel.tasks.collectAsState().value,
                                onAddClick = { showAddScreen = true }
                            )
                        }
                    }

                    else -> OnboardingPagerScreen(onDone = { showMainScreen = true })
                }
            }
        }
    }
}
