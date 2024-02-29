package com.skills.example.usingviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.skills.example.usingviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        clickListeners()


    }

    private fun clickListeners() {
        binding.apply {
            tvCounter.text = viewModel.getCounter().toString()
            btnIncrease.setOnClickListener {
                tvCounter.text = viewModel.increaseCounter().toString()
            }
        }
    }
}