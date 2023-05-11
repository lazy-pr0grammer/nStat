package com.aylax.nstat.ui.usage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aylax.nstat.databinding.FragmentUsageBinding

class UsageFragment : Fragment() {
    private lateinit var binding: FragmentUsageBinding
    private lateinit var viewModel: UsageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentUsageBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[UsageViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.dataUsageRv.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAll().observe(viewLifecycleOwner) {
            binding.dataUsageRv.adapter = UsageAdapter(it)
        }

    }

}