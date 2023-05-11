package com.aylax.nstat.data.model

import android.graphics.drawable.Drawable
import java.io.Serializable

 class App : Serializable {
    private var app_name: String? = null
    private var pkg_name: String? = null
    private var total_usage: String? = null
    private var icon: Drawable? = null
    var sent_mobile: Long = 0
    var sent_wifi: Long = 0
    var received_mobile: Long = 0
    var received_wifi: Long = 0
    private var mobile_total: Float? = null
    var wifi_total: Float? = null
    private var uid = 0
    var session = 0
    var type = 0
    var progress = 0
    var isSystemApp: Boolean? = null
    var isAppsList: Boolean? = null
    var dataLimit: String? = null
    var dataType: String? = null
    var list: List<App>? = null

    constructor(mAppName: String?, mAppIcon: Drawable?, mTotalDataUsage: String?) {
        app_name = mAppName
        icon = mAppIcon
        total_usage = mTotalDataUsage
    }

    constructor(
        mAppName: String?,
        mTotalDataUsage: String?,
        mAppIcon: Drawable?,
        mMobileTotal: Float?
    ) {
        app_name = mAppName
        total_usage = mTotalDataUsage
        icon = mAppIcon
        mobile_total = mMobileTotal
    }

    constructor(mAppName: String?, mPackageName: String?, uid: Int, isSystemApp: Boolean?) {
        app_name = mAppName
        pkg_name = mPackageName
        this.uid = uid
        this.isSystemApp = isSystemApp
    }

    constructor(
        mAppName: String?,
        mPackageName: String?,
        uid: Int,
        isSystemApp: Boolean?,
        isAppsList: Boolean?
    ) {
        app_name = mAppName
        pkg_name = mPackageName
        this.uid = uid
        this.isSystemApp = isSystemApp
        this.isAppsList = isAppsList
    }
}