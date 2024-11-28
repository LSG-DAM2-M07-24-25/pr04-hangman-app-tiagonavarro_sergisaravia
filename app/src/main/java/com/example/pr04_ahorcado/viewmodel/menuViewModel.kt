package com.example.pr04_ahorcado.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pr04_ahorcado.model.ahorcado


class menuViewModel : ViewModel() {

    private val _ahorcado = MutableLiveData(ahorcado(1))
    val dificultad: LiveData<ahorcado> = _ahorcado
    val selectDificutad = MutableLiveData<String>()
    fun onDificultSelected() {
        val currenAhorcado = _ahorcado.value ?: ahorcado(1)
        when (selectDificutad.value) {
            "facil" -> _ahorcado.value = currenAhorcado.copy(
                dificultad = 1
            )
            "moderado" -> _ahorcado.value = currenAhorcado.copy(
                dificultad = 2
            )
            "dificil" -> _ahorcado.value = currenAhorcado.copy(
                dificultad = 3
            )
            "imposible" -> _ahorcado.value = currenAhorcado.copy(
                dificultad = 4
            )
            else -> println("Valor no valido")
        }
        _ahorcado.value = currenAhorcado.copy(

        )
    }




}