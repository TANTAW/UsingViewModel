package com.skills.example.usingviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.skills.example.usingviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        clickListeners()

    }

    private fun clickListeners() {
        var count = 0
        binding.apply {
            btnIncrease.setOnClickListener {
                count++
                tvCounter.text = count.toString()
            }
        }
    }
}