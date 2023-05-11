package com.aylax.library.model

import android.graphics.drawable.Drawable

data class AppUsage(
    val name: String,
    val pkg_name: String,
    val icon: Drawable?,
    val mobile_usage: Long,
    val wifi_usage: Long,
    val total_usage: Long,
    val usage_percentage: Int
)
