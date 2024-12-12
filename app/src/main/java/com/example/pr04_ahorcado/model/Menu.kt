package com.example.pr04_ahorcado.model

import androidx.compose.runtime.key
//TODO Hacer que la puntuacion se printee correctamente
data class ahorcado(
    val wordsList: List<String> = listOf(
        "CASA", "GAT", "GOS", "TAULA", "CADIRA", "COTXE", "FLOR", "NUVOL", "MUNTANYA", "PLATJA",
        "MAR", "AIGUA", "SOL", "LLUNA", "ESTRELLA", "CARRER", "ESCOLA", "LLIBRE", "BOLIGRAF",
        "TREBALL", "AMISTAT", "FESTA", "MUSICA", "JARDI", "FAMÍLIA", "CIUTAT", "TREN", "AVENTURA",
        "MISTERI", "POEMA", "PLANETA", "PAIS", "CASTELL", "GUITARRA", "CINEMA", "TEATRE"
    ),
    val maxAttemts: Int = 6
){
    private var dificultad: Int = 1
    private var currentWord: String = wordsList.random()
    private var currentWordArray:  MutableList<Char> = currentWord.map {'_'}.toMutableList()
    private val selectedKeys: MutableSet<Char> = mutableSetOf()
    private var attemptsLeft: Int = maxAttemts
    private var gameOver: Boolean = false
    private var win: Boolean = false
    private var rondasGanadas: Int = 0
    private val easyWordlist: List<String> = listOf(
        "CASA", "GAT", "GOS", "FLOR", "MAR", "SOL", "TREN", "PAIS",
        "LUNA", "FOC", "PEU", "CEL", "OCELL", "POMA", "BOSC", "VENT",
        "LLAC", "CANT", "RAU", "TARD", "ROSA", "RIU", "CAMI", "NIU",
        "TEUL", "FOCA", "VAIX", "NEU", "PARE", "MOT", "JOC", "MIR",
        "DONA", "VIU", "SORT", "CAL"
    )
    private val mediumWordList: List<String> = listOf(
        "TAULA", "CADIRA", "COTXE", "NUVOL", "PLATJA", "AIGUA", "LLUNA", "CARRER",
        "ESCOLA", "LLIBRE", "FESTA", "MUSICA", "JARDI", "CIUTAT", "POEMA", "CINEMA",
        "TEATRE", "MUNTAR", "BALLAR", "CAMINS", "FINEST", "ESTACI", "ESTUDI", "CAIXES",
        "PAPER", "FUMADA", "BARRIS", "FALGUE", "PILOTA", "PESCAR", "CUINAR", "MIRALL",
        "BOSCOS", "AMICAR", "LLANÇA", "TARDOR"
    )
    private val dificultList: List<String> = listOf(
        "MUNTANYA", "ESTRELLA", "BOLIGRAF", "TREBALL", "AMISTAT", "FAMILIA", "AVENTURA",
        "MISTERI", "PLANETA", "CASTELL", "GUITARRA",
        "VESTIDOR", "LLEGEND", "REFUGIS", "VIATGER", "PINTURA", "SECRETS", "CALORADA",
        "SERRALL", "LLUMENER", "ESFORÇOS", "LLOVIZNA", "MIRADES", "BALLABLE", "HARMONIA",
        "ESQUIMAL", "PROGRAMA", "ESTIMADA", "VIATGES", "TARDORAL", "NEVADES", "SALTADOR",
        "CUINADOR"
    )
    private val impossibleList: List<String> = listOf(
        "ARQUITECT", "LLIBRERIA", "PROGRAMAR", "ESCRIPTOR", "EXPERIENCIA",
        "CONSTRUCC", "HOSPITALS", "ALIMENTACI", "INICIATIVA", "VOLUNTARI",
        "MEDITACIO", "SUGGERENT", "PERSEVERA", "ENIGMATIC", "DESAFIADOR",
        "COMUNICAR", "COLLECTIU", "APRENENTAT", "PERFECCIO", "DETERMINA",
        "CURIOSITA", "COORDINAR", "INSPIRADOR", "TRANSFORMA", "INNOVADORA",
        "ENTUSIASME", "PROTEGINT", "FORMIGUETA", "ENTRENADOR", "AMABILITAT",
        "ESTRUCTUR", "AUTOMATIC", "INTEGRACI", "CONFIANÇA", "ORIENTADOR",
        "COOPERATI"
    )




    fun resetGame() { //metodo para reiniciar juego
        currentWord = wordsList.random() //elije una palabra random del array
        currentWordArray = currentWord.map {'_'}.toMutableList() //devuelve todos los datos para que se printeen como '_'
        selectedKeys.clear()
        attemptsLeft = maxAttemts
        gameOver = false
        win = false
    }
    fun incrementarPuntuacion(){
        rondasGanadas++
    }
    fun resetPuntuacion() {
        rondasGanadas = 0
    }

    //Metodos get
    fun getWordState(): List<Char> = currentWordArray
    fun getAttemptsLeft(): Int = attemptsLeft
    fun getRondasGanadas(): Int = rondasGanadas
    fun isGameOver(): Boolean = gameOver
    fun didWin(): Boolean = win
    fun getDificultad(): Int = dificultad

    fun selectKey(key : Char) {
        if (gameOver || selectedKeys.contains(key)) return
        selectedKeys.add(key)
        if (key in currentWord) {
            currentWordArray = currentWordArray.mapIndexed { index, existingChar ->
                if (existingChar != '_') existingChar
                else if (currentWord[index] == key) key
                else '_'
            }.toMutableList()

        } else {
            attemptsLeft--
        }
        if (!currentWordArray.contains('_')) { //comprueba que no hay ningun '_' por lo tanto el jugador habria ganado
            win = true
            gameOver = true
        } else {
            if (attemptsLeft <= 0){
                gameOver = true
                win = false
            }
        }
    }

    fun getSelectedKeys(): Set <Char> = selectedKeys

}

