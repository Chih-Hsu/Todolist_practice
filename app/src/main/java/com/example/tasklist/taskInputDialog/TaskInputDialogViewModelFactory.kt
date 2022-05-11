package com.example.tasklist.taskInputDialog

import android.text.Editable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tasklist.database.TaskDataDAO

class TaskInputDialogViewModelFactory(private val database: TaskDataDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskInputDialogViewModel::class.java)){
            return TaskInputDialogViewModel(database)  as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}