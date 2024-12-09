package com.example.pr04_ahorcado.viewmodel
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pr04_ahorcado.model.ahorcado
import androidx.compose.runtime.State


class menuViewModel : ViewModel() {


    private val _ahorcado = MutableLiveData(ahorcado(1))
    private val game = ahorcado()

    private val _wordState = mutableStateOf(game.getWordState())
    val wordState: State<List<Char>> = _wordState

    private val _attemptsLeft = mutableStateOf(game.getAttemptsLeft())
    val attemptsLeft: State<Int> = _attemptsLeft

    private val _gameOver = mutableStateOf(game.isGameOver())
    val gameOver: State<Boolean> = _gameOver

    private val _win = mutableStateOf(game.didWin())
    val win: State<Boolean> = _win

    private val _selectedKeys = mutableStateOf(game.getSelectedKeys())
    val selectedKeys: State<Set<Char>> = _selectedKeys

    private val _rondasGanadas = mutableStateOf(game.getRondasGanadas())
    val rondasGanadas: State<Int> = _rondasGanadas

    fun resetGame(){
        game.resetGame()
        updateState()
    }

    fun resetPuntuacion(){
        game.resetPuntuacion()
        updateState()
    }

    fun selectKey(key: Char) {
        game.selectKey(key)
        updateState()
    }

    private fun updateState() {
        _wordState.value = game.getWordState()
        _attemptsLeft.value = game.getAttemptsLeft()
        _gameOver.value = game.isGameOver()
        _win.value = game.didWin()
        _selectedKeys.value = game.getSelectedKeys()
        _rondasGanadas.value = game.getRondasGanadas()
    }


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