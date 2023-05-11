package com.aylax.nstat.ui.main;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.aylax.nstat.R;
import com.aylax.nstat.databinding.ActivityMainBinding;
import com.aylax.nstat.util.Utils;
import com.google.android.material.elevation.SurfaceColors;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());

    setContentView(binding.getRoot());
    setupNavigation();
    init();
  }

  private void init() {
    setSupportActionBar(binding.toolbar);
    Utils.setToolbarFont(binding.toolbar);
    Utils.navigationFont(binding.navigation);
    getWindow().setStatusBarColor(SurfaceColors.SURFACE_2.getColor(this));
    getWindow().setNavigationBarColor(SurfaceColors.SURFACE_2.getColor(this));
    binding.toolbar.setBackgroundColor(SurfaceColors.SURFACE_2.getColor(this));
  }

  private void setupNavigation() {
    binding.toolbar.setTitle("Usage");
    binding.navigation.setOnItemSelectedListener(
        item -> {
          int id = item.getItemId();
          binding.toolbar.setTitle(item.getTitle());
          if (id == R.id.usage) {

          } else if (id == R.id.stat) {

          } else if (id == R.id.speed) {

          } else if (id == R.id.settings) {

          }
          return true;
        });
  }
}
