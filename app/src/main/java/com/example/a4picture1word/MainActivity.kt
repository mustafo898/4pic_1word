package com.example.a4picture1word

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.a4picture1word.databinding.ActivityMainBinding
//import uz.micro.star.lesson_9.databinding.ActivityMainBinding
import com.example.a4picture1word.manager.GameManager
import com.example.a4picture1word.models.QuestionData
import com.example.a4picture1word.shared.SharedPreferenceHelper
import com.example.a4picture1word.utils.gone
import com.example.a4picture1word.utils.invisible
import com.example.a4picture1word.utils.isInvisible
import com.example.a4picture1word.utils.visible
import java.sql.Array
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val shared by lazy {
        SharedPreferenceHelper(this)
    }
    private var string: String = ""
    private lateinit var binding: ActivityMainBinding
    lateinit var questionsList: ArrayList<QuestionData>
    lateinit var imagesList: ArrayList<ImageView>
    lateinit var wordList: ArrayList<Button>
    lateinit var lettersList: ArrayList<Button>
    lateinit var gameManager: GameManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gameManager = GameManager(questionsList, 1, 0)

        getAllQuestions()
        loadViews()
        loadDataToView()
    }

    private fun getAllQuestions() {
        questionsList = ArrayList()
        questionsList.add(
            QuestionData(
                1,
                arrayListOf(
                    R.drawable.img1,
                    R.drawable.img1,
                    R.drawable.img1,
                    R.drawable.img1,
                ),
                "Hello",
                "asldfgheloq"
            )
        )
        questionsList.add(
            QuestionData(
                2,
                arrayListOf(
                    R.drawable.img1,
                    R.drawable.img1,
                    R.drawable.img1,
                    R.drawable.img1,
                ),
                "Salom",
                "Stajlnsuom"
            )
        )
        questionsList.add(
            QuestionData(
                3,
                arrayListOf(
                    R.drawable.img1,
                    R.drawable.img1,
                    R.drawable.img1,
                    R.drawable.img1,
                ),
                "tank",
                "tfqtoanykk"
            )
        )
    }

    private fun loadViews() {
        imagesList = ArrayList()
        for (i in 0 until binding.imagesLayout.childCount) {
            imagesList.add(binding.imagesLayout.getChildAt(i) as ImageView)
        }
        /////////
        wordList = ArrayList()
        for (i in 0 until binding.wordLayout.childCount) {
            wordList.add(binding.wordLayout.getChildAt(i) as Button)
            wordList[i].setOnClickListener {
                wordBtnClick(it as Button)
            }
        }
        ///////////
        lettersList = ArrayList()
        for (i in 0 until binding.letterLayout.childCount) {
            lettersList.add(binding.letterLayout.getChildAt(i) as Button)
            lettersList[i].setOnClickListener {
                letterBtnClick(it as Button)
            }
        }
    }

    private fun letterBtnClick(button: Button) {
        if (button.isVisible && wordList[gameManager.getWordSize() - 1].text.isEmpty()) {
            button.invisible()

            var word = button.text.toString()

            for (i in 0 until wordList.size) {
                if (wordList[i].text.isEmpty()) {
                    wordList[i].text = word
                    break
                }
            }

            for (i in 0 until wordList[gameManager.getWordSize()-1].length()){
                string+=wordList[i].toString()
                if (gameManager.check(string)){
                    Toast.makeText(this, "win", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun wordBtnClick(it: Button) {

        if (it.text.isNotEmpty()) {
            val word = it.text.toString()
            it.text = ""

            for (i in 0 until lettersList.size) {

                if (lettersList[i].isInvisible()
                    && lettersList[i].text.toString().lowercase() == word.lowercase()
                ) {
                    lettersList[i].visible()
                    break
                }
            }
        }
    }

    private fun loadDataToView() {
        for (i in 0 until imagesList.size) {
            imagesList[i].setImageResource(gameManager.getQuestions()[i])
        }
        /////////
        for (i in 0 until wordList.size) {
            if (gameManager.getWordSize() > i) {
                wordList[i].visible()
                wordList[i].text = ""
                string
            } else {
                wordList[i].gone()
            }
        }
        ////////
        for (i in 0 until lettersList.size) {
            lettersList[i].visible()
            lettersList[i].text = "${gameManager.getLetters()[i]}"
        }
    }

    fun shuffle(){
//        var otherLetter =
    }
}

