package com.skills.example.usingviewmodel

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private var counter = 0

    fun getCounter(): Int = counter

    fun increaseCounter(): Int = ++counter

}