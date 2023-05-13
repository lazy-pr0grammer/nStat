package com.aylax.library.model

data class UsageValues(
    var networkRange: DateRange? = null,
    var traffic: Traffic? = null,
    var wifiTraffic: Traffic? = null,
    var mobileTraffic: Traffic? = null
)
