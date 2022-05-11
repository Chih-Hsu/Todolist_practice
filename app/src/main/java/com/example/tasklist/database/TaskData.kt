package com.example.tasklist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_data_table")
data class TaskData(
    @PrimaryKey(autoGenerate = true)
    var taskId : Long,
    @ColumnInfo(name = "title")
    var title : String
//    @ColumnInfo(name = "start_time")
//    var startTime:Long,
//    @ColumnInfo(name = "end_time")
//    var endTime:Long
)