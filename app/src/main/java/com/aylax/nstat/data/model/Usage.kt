package com.aylax.nstat.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usage")
data class Usage(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "timestamp")
    val timestamp: String,
    @ColumnInfo(name = "data_usage")
    val data_usage: Long,
    @ColumnInfo("wifi_usage")
    val wifi_usage: Long,
    @ColumnInfo("total_usage")
    val total_usage: Long
)
