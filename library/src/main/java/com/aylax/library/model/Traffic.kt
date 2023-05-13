package com.aylax.library.model

data class Traffic(
    var rxPkts: Long? = 0,
    var txPkts: Long? = 0,
    var rxbyts: Long? = 0,
    var txByts: Long? = 0,
    var kb: Int? = 1024,
    var mb: Int? = kb?.times(kb)
)
