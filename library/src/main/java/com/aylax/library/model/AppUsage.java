package com.aylax.library.model;

import android.graphics.drawable.Drawable;

public class AppUsage {
  public Drawable icon;
  public int usage_percentage;
  public String name, pkg_name;
  public long mobile_usage, wifi_usage, total_usage;

  public AppUsage(
      String name,
      String pkg_name,
      Drawable icon,
      int usage_percentage,
      long mobile_usage,
      long wifi_usage,
      long total_usage) {
    this.icon = icon;
    this.name = name;
    this.pkg_name = pkg_name;
    this.wifi_usage = wifi_usage;
    this.total_usage = total_usage;
    this.mobile_usage = mobile_usage;
    this.usage_percentage = usage_percentage;
  }
}
