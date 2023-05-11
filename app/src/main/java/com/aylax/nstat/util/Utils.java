package com.aylax.nstat.util;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import com.aylax.nstat.R;

public class Utils {

  public static void showToast(Context context, String message) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
  }

  public static boolean isNightMode(@NonNull Context context) {
    int nightModeFlags =
        context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
    return nightModeFlags == Configuration.UI_MODE_NIGHT_YES;
  }

  public static void setToolbarFont(@NonNull Toolbar toolbar) {
    for (int i = 0; i < toolbar.getChildCount(); i++) {
      View view = toolbar.getChildAt(i);
      if (view instanceof TextView) {
        ((TextView) view)
            .setTypeface(ResourcesCompat.getFont(toolbar.getContext(), R.font.manrope_bold));
      }
    }
  }

  public static void navigationFont(View v) {
    try {
      if (v instanceof ViewGroup) {
        ViewGroup vg = (ViewGroup) v;
        for (int i = 0; i < vg.getChildCount(); i++) {
          View child = vg.getChildAt(i);
          navigationFont(child);
        }
      } else if (v instanceof TextView) {
        ((TextView) v).setTypeface(ResourcesCompat.getFont(v.getContext(), R.font.manrope_bold));
      }
    } catch (Exception e) {
    }
  }
}
