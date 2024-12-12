package com.example.pr04_ahorcado.viewmodel
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pr04_ahorcado.model.ahorcado
import androidx.compose.runtime.State


class menuViewModel : ViewModel() {



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

    private val _rondasGanadas = MutableLiveData(game.getRondasGanadas())
    val rondasGanadas: MutableLiveData<Int> = _rondasGanadas

    private val _dificultad = mutableStateOf(game.getDificultad())
    val dificultad: State<Int> = _dificultad


    fun resetGame(){
        game.resetGame()
        updateState()
    }

    fun incrementarPuntuacion() {
        game.incrementarPuntuacion()
        _rondasGanadas.value = game.getRondasGanadas() // Asegura que el LiveData se actualice
    }


    fun resetPuntuacion(){
        game.resetPuntuacion()
        updateState()
    }

    fun selectKey(key: Char) {
        game.selectKey(key)
        updateState()
    }

    fun updateState() {
        _wordState.value = game.getWordState()
        _attemptsLeft.value = game.getAttemptsLeft()
        _gameOver.value = game.isGameOver()
        _win.value = game.didWin()
        _selectedKeys.value = game.getSelectedKeys()
        _rondasGanadas.value = game.getRondasGanadas()
    }



    fun onDificultSelected(dif : String) {
        _dificultad.value = game.getDificultad()
        game.selectDificultad(dif)
    }




}