package com.aylax.nstat.ui.main;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.aylax.nstat.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());

    setContentView(binding.getRoot());

    new TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager,
            ((tab, position) -> tab.setText("pos" + position)))
        .attach();

    binding.viewPager.setAdapter(new ViewpagerAdapter(getSupportFragmentManager(), getLifecycle()));
  }
}
