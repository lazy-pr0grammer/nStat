package com.aylax.library.api;

import android.annotation.SuppressLint;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import com.aylax.library.model.AppUsage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsageManager {
  private final NetworkStatsManager manager;
  private final TelephonyManager mngr;
  private final PackageManager pm;
  private final Context context;

  @SuppressLint("NewApi")
  public UsageManager(Context context) {
    manager = (NetworkStatsManager) context.getSystemService(Context.NETWORK_STATS_SERVICE);
    mngr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    pm = context.getPackageManager();
    this.context = context;
  }

  public List<AppUsage> getUsage(long start, long end) {
    List<AppUsage> usages = new ArrayList<>();
    List<ApplicationInfo> applicationInfo =
        pm.getInstalledApplications(PackageManager.GET_META_DATA);

    for (ApplicationInfo info : applicationInfo) {
      usages.add(new AppUsage(info.loadLabel(pm).toString(), info.packageName, info.loadIcon(pm), 0, 0, 0, 0));
    }

    return usages;
  }
}
