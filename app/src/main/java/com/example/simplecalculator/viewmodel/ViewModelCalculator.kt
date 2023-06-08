package com.example.simplecalculator.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ViewModelCalculator: ViewModel() {

    var expression = ""
    var memo ="0"
    var isOperator = false
    var isPoint = false
    var isNumber = false

    private val _expressionFlow = MutableSharedFlow<String>()
    val expressionFlow = _expressionFlow.asSharedFlow()


    val txt = expressionFlow.map {
     Log.d("tag","expression viewmodel $it")
    }.launchIn(viewModelScope)

    fun setExpress(txt: String){
        viewModelScope.launch {
            expression += txt
            _expressionFlow.emit(expression)
        }
    }
    fun setExpressionDel(){
        viewModelScope.launch {
            expression = expression.substring(0, expression.length -1)
            _expressionFlow.emit(expression)
        }
    }


    fun egaleActualise(){
        viewModelScope.launch {
            _expressionFlow.emit(expression)
        }
    }
}