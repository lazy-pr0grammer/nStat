package com.aylax.nstat.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aylax.nstat.data.model.Usage

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usage: Usage)

    @Query("UPDATE usage SET wifi_usage = wifi_usage + :usage, total_usage = total_usage + :usage WHERE id = :id")
    suspend fun updateWifiUsage(id: Int, usage: Long)

    @Query("UPDATE usage SET data_usage = data_usage + :usage, total_usage = total_usage + :usage WHERE id = :id")
    suspend fun updateDataUsage(id: Int, usage: Long)

    @Query("SELECT * FROM usage WHERE id = :id")
    fun getDayUsage(id: Int): LiveData<Usage>

    @Query("SELECT * FROM usage ORDER BY timestamp DESC limit 30")
    fun getAll(): LiveData<List<Usage>>
}