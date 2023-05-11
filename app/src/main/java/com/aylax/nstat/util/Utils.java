package com.aylax.nstat.util;

import android.content.Context;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

public class Utils {
  public static boolean isNightMode(@NonNull Context context) {
    int nightModeFlags =
        context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
    return nightModeFlags == Configuration.UI_MODE_NIGHT_YES;
  }
}
