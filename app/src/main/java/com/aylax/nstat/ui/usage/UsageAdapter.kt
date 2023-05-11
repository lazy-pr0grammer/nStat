package com.aylax.nstat.ui.usage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aylax.library.model.AppUsage
import com.aylax.nstat.databinding.ItemAppUsageBinding

class UsageAdapter(val appUsage: List<AppUsage>) : RecyclerView.Adapter<UsageAdapter.ViewHolder>() {
    private var binding: ItemAppUsageBinding? = null

    class ViewHolder(var binding: ItemAppUsageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(appUsage: AppUsage) {
            binding.appName.text = appUsage.name
            binding.usage.text = appUsage.total_usage.toString()
            binding.imageView.setImageDrawable(appUsage.icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemAppUsageBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding!!)
    }

    override fun getItemCount(): Int {
        return appUsage.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(appUsage[position])
    }
}