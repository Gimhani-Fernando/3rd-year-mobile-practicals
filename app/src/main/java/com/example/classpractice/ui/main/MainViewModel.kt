package com.example.classpractice.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var result = MutableLiveData<Double>(0.0)

    fun add(number1:Double, number2:Double){
        result.value = number1.plus(number2)
        Log.d("Add Result",result.value.toString())
    }

}