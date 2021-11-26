package com.benjaminespi.basketballpractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _scoreLocal: MutableLiveData<Int> = MutableLiveData()
    private var _scoreVisit: MutableLiveData<Int> = MutableLiveData()

    val scoreLocalLiveData: LiveData<Int>
    get() = _scoreLocal

    val scoreVisitLiveData: LiveData<Int>
    get()= _scoreVisit

    init {
        restartScore()
    }

    fun restartScore(){
        _scoreLocal.value = 0
        _scoreVisit.value = 0
    }
    fun addScore(points: Int, isLocal: Boolean){
        if(isLocal){
            _scoreLocal.value = _scoreLocal.value?.plus(points)
        } else{
            _scoreVisit.value= _scoreVisit.value?.plus(points)
        }
    }

    fun decreaseLocalScore(){
        if(_scoreLocal.value!! > 0) {
            _scoreLocal.value = _scoreLocal.value?.minus(1)
        }
    }
    fun decreaseVisitScore(){
        if(_scoreLocal.value!! > 0) {
            _scoreVisit.value = _scoreVisit.value?.minus(1)
        }
    }
}