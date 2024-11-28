package com.example.pr04_ahorcado.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pr04_ahorcado.model.menu

class menuViewModel : ViewModel() {

    private val _dificultad = MutableLiveData(menu(1))
    val dificultad: LiveData<menu> = _dificultad
    fun onPlayClicked() {
        val dificultad = _dificultad.value ?: menu
    }




}