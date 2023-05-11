package com.aylax.nstat.data.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aylax.nstat.data.model.Usage

@Database(entities = [Usage::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE != null) {
                return INSTANCE as AppDatabase
            }
            synchronized(this) {
                INSTANCE =
                    Room.databaseBuilder(context, AppDatabase::class.java, "nstat_db").build()
                return INSTANCE as AppDatabase
            }
        }

    }
}