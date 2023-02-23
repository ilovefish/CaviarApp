package com.ilovefish.caviarapp.demo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel2 : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is 抢单 Fragment two"
    }
    val text: LiveData<String> = _text
}