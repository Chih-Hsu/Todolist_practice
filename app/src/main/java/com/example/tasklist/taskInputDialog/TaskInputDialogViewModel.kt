package com.example.tasklist.taskInputDialog


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tasklist.database.TaskData
import com.example.tasklist.database.TaskDataDAO
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

class TaskInputDialogViewModel(
    private val database: TaskDataDAO
) : ViewModel() {

    private val viewModelJob = Job()



    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val newTask = MutableLiveData<TaskData>()

    // When newTask.value = null then navigate
    private val _navigationToMain = MutableLiveData<Boolean>()
    val navigationToMain: LiveData<Boolean>
        get() = _navigationToMain


    fun addNewTask(text:String) {
        uiScope.launch {  val task = TaskData()
        task.title = text
        insert(task)
        _navigationToMain.value = true}
    }

    private suspend fun insert(task : TaskData){
        withContext(Dispatchers.IO){
            database.insert(task)
        }

    }

    fun doneNavigation(){
        _navigationToMain.value = false
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}