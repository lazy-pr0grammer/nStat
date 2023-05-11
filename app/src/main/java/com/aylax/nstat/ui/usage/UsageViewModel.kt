package com.aylax.nstat.ui.usage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.aylax.library.model.AppUsage
import com.aylax.nstat.data.model.Usage
import com.aylax.nstat.data.repository.UsageRepository

class UsageViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = UsageRepository(application)

     fun getAll(): LiveData<List<AppUsage>> {
        return repository.getAll()
    }

}