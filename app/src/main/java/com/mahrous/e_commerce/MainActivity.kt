package com.mahrous.e_commerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.mahrous.e_commerce.adapter.HomeAdapter
import com.mahrous.e_commerce.databinding.ActivityMainBinding
import com.mahrous.e_commerce.viewModels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModels();
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        viewModel.getHome("1", 7)
        lifecycleScope.launch {
            viewModel.categories.collect {
                val adapter = HomeAdapter();
                adapter.submitList(it)
                Log.e("TAG", "onCreate: "+it?.size )
                binding.ourtop.adapter = adapter

            }
        }

        viewModel.getHome("1", 8)
        lifecycleScope.launch {
            viewModel.categories.collect {
                val adapter = HomeAdapter();
                adapter.submitList(it)
                Log.e("TAG", "onCreate: "+it?.size )
                binding.bestSeller.adapter = adapter

            }
        }


        viewModel.getHome("1", 0)
        lifecycleScope.launch {
            viewModel.categories.collect {
                val adapter = HomeAdapter();
                adapter.submitList(it)
                Log.e("TAG", "onCreate: "+it?.size )
                binding.catogries.adapter = adapter

            }
        }

    }
}