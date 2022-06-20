package com.mustafo.a4picture1word.managers

import com.mustafo.a4picture1word.models.QuestionData
import java.util.*

class GameManager(
    var questionsList: ArrayList<QuestionData>,
    var level: Int,
    var coins: Int,
    var help:Int
) {
    private fun question() = questionsList[level]
//    fun getQuestions() = question().imageList
    fun getWord() = question().word.uppercase()
    fun getWordLowercase() = question().word.lowercase()
    fun getWordSize() = question().word.length
    fun getLetters() = question().letters
    fun getLettersSize() = question().letters.length
    fun questionsSize() = questionsList.size
    fun check(word: String):Boolean{

        return getWord().trim().lowercase() == word.lowercase()
    }

}