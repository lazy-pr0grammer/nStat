package com.aylax.library.api;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.aylax.library.model.AppUsage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class UsageManager {
  private final UsageStatsManager manager;
  private final PackageManager pm;

  public UsageManager(Context context) {
    manager = (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);
    pm = context.getPackageManager();
  }

  public List<AppUsage> getUsage(long start, long end) {
    Map<String, UsageStats> queryUsageStats = manager.queryAndAggregateUsageStats(start, end);
    List<AppUsage> appUsageList = new ArrayList<>();
    for (Map.Entry<String, UsageStats> usageStatsEntry : queryUsageStats.entrySet()) {
      String packageName = usageStatsEntry.getKey();
      UsageStats usageStats = usageStatsEntry.getValue();
      try {
        PackageInfo packageInfo = pm.getPackageInfo(packageName, 0);
        String appName = packageInfo.applicationInfo.loadLabel(pm).toString();
        Drawable appIcon = packageInfo.applicationInfo.loadIcon(pm);
        long mobileDataUsage = usageStats.getLastTimeUsed();
        long wifiDataUsage = usageStats.getTotalTimeInForeground() - mobileDataUsage;
        long totalDataUsage = wifiDataUsage + mobileDataUsage;
        int dataUsagePercentage =
            calculateDataUsagePercentage(totalDataUsage, mobileDataUsage, wifiDataUsage);
        appUsageList.add(
            new AppUsage(
                appName,
                packageName,
                appIcon,
                mobileDataUsage,
                wifiDataUsage,
                totalDataUsage,
                dataUsagePercentage));
      } catch (PackageManager.NameNotFoundException e) {
        Log.e(UsageManager.class.getSimpleName(), "Package name not found: " + packageName, e);
      }
    }

    Collections.sort(
        appUsageList, (o1, o2) -> Long.compare(o2.getTotal_usage(), o1.getTotal_usage()));

    return appUsageList;
  }

  private int calculateDataUsagePercentage(
      long totalDataUsage, long mobileDataUsage, long wifiDataUsage) {
    if (totalDataUsage > 0) {
      return (int) ((mobileDataUsage + wifiDataUsage) * 100 / totalDataUsage);
    } else {
      return 0;
    }
  }
}
