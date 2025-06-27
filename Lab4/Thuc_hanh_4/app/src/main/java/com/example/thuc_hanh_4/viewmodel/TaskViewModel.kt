package com.example.thuc_hanh_4.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.thuc_hanh_4.model.Task

class TaskViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    fun addTask(task: Task) {
        _tasks.value = _tasks.value + task
    }

    fun removeTask(task: Task) {
        _tasks.value = _tasks.value - task
    }

    fun clearAll() {
        _tasks.value = emptyList()
    }
}
