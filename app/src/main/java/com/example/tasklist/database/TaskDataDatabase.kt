package com.example.tasklist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TaskData::class], version = 1, exportSchema = false)
abstract class TaskDataDatabase : RoomDatabase(){

    abstract val taskDataDao : TaskDataDAO
    companion object{
        @Volatile
        private var INSTANCE : TaskDataDatabase? = null
        fun getInstance(context : Context):TaskDataDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDataDatabase::class.java,   //用來建立database的class
                        "task_data_database"     //這個database的name
                    ).fallbackToDestructiveMigration() //一般來說需定義舊資料庫到新資料庫的遷移方式
                        .build()
                    INSTANCE = instance
                }
                return instance
            }

                }
}
}