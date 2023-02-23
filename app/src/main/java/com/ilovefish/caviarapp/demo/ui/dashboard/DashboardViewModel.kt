package com.ilovefish.caviarapp.demo.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is 拍拍 Fragment"
    }
    val text: LiveData<String> = _text
}