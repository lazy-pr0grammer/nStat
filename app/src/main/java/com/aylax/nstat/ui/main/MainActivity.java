package com.aylax.nstat.ui.main;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.aylax.nstat.R;
import com.aylax.nstat.databinding.ActivityMainBinding;
import com.aylax.nstat.util.Utils;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());

    setContentView(binding.getRoot());
    String[] names = {"MOBILE DATA", "WI-FI"};
    if (!Utils.isNightMode(this))
      getWindow()
          .setStatusBarColor(ContextCompat.getColor(this, R.color.md_theme_light_background));
    else
      getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.md_theme_dark_background));
    binding.viewPager.setAdapter(new ViewpagerAdapter(getSupportFragmentManager(), getLifecycle()));
    new TabLayoutMediator(
            binding.tabLayout, binding.viewPager, ((tab, position) -> tab.setText(names[position])))
        .attach();
  }
}
