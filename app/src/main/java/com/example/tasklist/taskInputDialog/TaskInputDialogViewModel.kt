package com.example.tasklist.taskInputDialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tasklist.database.TaskData
import com.example.tasklist.database.TaskDataDAO

class TaskInputDialogViewModel(
    private val database: TaskDataDAO
) : ViewModel() {

    private val newTask = MutableLiveData<TaskData>()

    // When newTask.value = null then
    private val _navigationToMain = MutableLiveData<TaskData>()
    val navigationToMain: LiveData<TaskData>
        get() = _navigationToMain


    private fun addNewTask() {
        newTask.value = database.getLastTask()

    }

}