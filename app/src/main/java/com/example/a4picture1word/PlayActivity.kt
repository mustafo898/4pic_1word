package com.example.a4picture1word

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import com.example.a4picture1word.databinding.ActivityMainBinding
import com.example.a4picture1word.databinding.ActivityPlayBinding
import com.example.a4picture1word.managers.GameManager
import com.example.a4picture1word.models.QuestionData
import com.example.a4picture1word.utils.gone
import com.example.a4picture1word.utils.invisible
import com.example.a4picture1word.utils.isInvisible
import com.example.a4picture1word.utils.visible
import com.thecode.aestheticdialogs.AestheticDialog
import com.thecode.aestheticdialogs.DialogAnimation

import com.thecode.aestheticdialogs.DialogStyle
import com.thecode.aestheticdialogs.DialogType


class PlayActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlayBinding
    lateinit var questionsList: ArrayList<QuestionData>
    lateinit var imagesList: ArrayList<ImageView>
    lateinit var wordList: ArrayList<AppCompatButton>
    lateinit var lettersList: ArrayList<AppCompatButton>
    lateinit var gameManager: GameManager
    var string = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getAllQuestions()
        gameManager = GameManager(questionsList, 0, 0)
        loadViews()
        loadDataToView()


    }

    private fun getAllQuestions() {
        questionsList = ArrayList()
        questionsList.add(
            QuestionData(
                arrayListOf(
                    R.drawable.img1,
                    R.drawable.img1,
                    R.drawable.img1,
                    R.drawable.img1,
                ),
                "Helo",
                "asdfgheloq"
            )
        )
        questionsList.add(
            QuestionData(
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
            wordList.add(binding.wordLayout.getChildAt(i) as AppCompatButton)
            wordList[i].setOnClickListener {
                wordBtnClick(it as Button)
            }
        }
        ///////////
        lettersList = ArrayList()
        for (i in 0 until binding.letterLayout.childCount) {
            lettersList.add(binding.letterLayout.getChildAt(i) as AppCompatButton)
            lettersList[i].setOnClickListener {
                letterBtnClick(it as Button)
            }
        }

        binding.submit.setOnClickListener {
            if (check_()) {
                Toast.makeText(this, "Win", Toast.LENGTH_LONG).show()
                Thread.sleep(500)
                gameManager.coins += 15
                binding.coin.text = gameManager.coins.toString()

                gameManager.level++

                var level_ = gameManager.level

                binding.level.text = (++level_).toString()
                getAllQuestions()
                loadDataToView()
                string = ""
            } else {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnClear.setOnClickListener {
            clear()
        }
    }

    fun check_(): Boolean {
        for (i in 0 until gameManager.getWordSize()) {
            string += wordList[i].text
        }
        return gameManager.check(string)
    }

    fun clear(){
        for (i in 0 until gameManager.getWordSize()){
            wordList[i].text=""
        }
        string=""
        for (i in 0 until lettersList.size) {
            lettersList[i].visible()
            lettersList[i].text = "${gameManager.getLetters()[i]}"
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
        string = ""
    }

    private fun loadDataToView() {
        var level_ = gameManager.level
        binding.level.text = (++level_).toString()
        binding.coin.text = "0"
        for (i in 0 until imagesList.size) {
            imagesList[i].setImageResource(gameManager.getQuestions()[i])
        }
        /////////
        for (i in 0 until wordList.size) {
            if (gameManager.getWordSize() > i) {
                wordList[i].visible()
                wordList[i].text = ""
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
}