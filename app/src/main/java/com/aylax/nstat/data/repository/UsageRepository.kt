package com.aylax.nstat.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aylax.library.api.UsageManager
import com.aylax.library.model.AppUsage
import com.aylax.nstat.data.dao.AppDatabase
import com.aylax.nstat.data.model.Usage

class UsageRepository(val context: Context) {
    private val dao = AppDatabase.getInstance(context).appDao()

    suspend fun insert(usage: Usage) {
        dao.insert(usage)
    }

    suspend fun updateWifiUsage(id: Int, usage: Long) {
        dao.updateWifiUsage(id, usage)
    }

    suspend fun updateDataUsage(id: Int, usage: Long) {
        dao.updateDataUsage(id, usage)
    }

    public fun getAll(): LiveData<List<AppUsage>> {
        val result: MutableLiveData<List<AppUsage>> = MutableLiveData()
        result.value = UsageManager(context).getUsage(1689196800000, System.currentTimeMillis())
        return result
    }
}