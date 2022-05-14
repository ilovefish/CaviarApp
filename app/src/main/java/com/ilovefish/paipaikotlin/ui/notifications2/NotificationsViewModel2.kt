package com.ilovefish.paipaikotlin.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel2 : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is 房域 Fragment"
    }
    val text: LiveData<String> = _text
}