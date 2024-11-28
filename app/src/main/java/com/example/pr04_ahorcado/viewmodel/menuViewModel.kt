package com.example.pr04_ahorcado.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pr04_ahorcado.model.ahorcado
import com.example.pr04_ahorcado.model.menu

class menuViewModel : ViewModel() {

    private val _ahorcado = MutableLiveData(ahorcado(1))
    val dificultad: LiveData<ahorcado> = _ahorcado
    val selectDificutad = MutableLiveData<Int>()
    fun onPlayClicked() {
        val currenAhorcado = _ahorcado.value ?: ahorcado(1)
        when (selectDificutad.value) {
            1 -> _ahorcado.value = currenAhorcado.copy(
                dificultad = 1
            )
            2 -> _ahorcado.value = currenAhorcado.copy(
                dificultad = 2
            )
            3 -> _ahorcado.value = currenAhorcado.copy(
                dificultad = 3
            )
            4 -> _ahorcado.value = currenAhorcado.copy(
                dificultad = 4
            )
            else -> println("Valor no valido")
        }
        _ahorcado.value = currenAhorcado.copy(

        )
    }




}