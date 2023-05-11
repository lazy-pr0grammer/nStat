package com.aylax.nstat.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.aylax.nstat.ui.data.DataFragment;

public class ViewpagerAdapter extends FragmentStateAdapter {
  public ViewpagerAdapter(@NonNull FragmentManager manager, @NonNull Lifecycle lifecycle) {
    super(manager, lifecycle);
  }

  @NonNull
  @Override
  public Fragment createFragment(int position) {
    return new DataFragment();
  }

  @Override
  public int getItemCount() {
    return 2;
  }
}
