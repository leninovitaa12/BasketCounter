package com.example.basketcounter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class scoreViewModel : ViewModel() {

    val teamA = MutableLiveData<String>()
    val teamB = MutableLiveData<String>()
    var scoreA = 0
    var scoreB = 0

    fun Incremet(_isA: Boolean) {
        if (_isA == true) {
            scoreA++
        } else {
            scoreB++
        }
    }
}