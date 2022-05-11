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

    // When newTask.value = null then navigate
    private val _navigationToMain = MutableLiveData<Boolean>()
    val navigationToMain: LiveData<Boolean>
        get() = _navigationToMain


    fun addNewTask(text:String):TaskData? {
        val task = database.getLastTask()
        if (task != null)task.title = text
        _navigationToMain.value = true
        return task
    }

    fun doneNavigation(){
        _navigationToMain.value = false
    }

}