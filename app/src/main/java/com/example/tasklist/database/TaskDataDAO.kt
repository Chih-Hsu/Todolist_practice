package com.example.tasklist.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDataDAO {

    @Insert
    fun insert(task:TaskData)

    @Update
    fun update(task: TaskData)

    @Query("SELECT*FROM task_data_table  WHERE taskId = :key")
    fun get(key:Long):TaskData?

    @Query("DELETE FROM task_data_table")
    fun clear()

    @Query("SELECT*FROM task_data_table ORDER BY taskId DESC")
    fun getAllTasks():LiveData<List<TaskData>>

    @Query("SELECT * FROM task_data_table ORDER BY taskId DESC LIMIT 1")
    fun getLastTask(): TaskData?
}