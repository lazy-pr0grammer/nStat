package com.aylax.nstat.ui.usage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aylax.library.model.AppUsage
import com.aylax.nstat.data.repository.UsageRepository

class UsageViewModel : ViewModel() {
    private val repository = UsageRepository()

    fun getAll(): LiveData<List<AppUsage>> {
        return repository.getAll()
    }

}