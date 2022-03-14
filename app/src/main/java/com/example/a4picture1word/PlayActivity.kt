package com.example.a4picture1word

import android.app.backup.SharedPreferencesBackupHelper
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.a4picture1word.databinding.ActivityMainBinding
import com.example.a4picture1word.databinding.ActivityPlayBinding
import com.example.a4picture1word.managers.GameManager
import com.example.a4picture1word.models.QuestionData
import com.example.a4picture1word.shared.Shared
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
    val shared by lazy {
        Shared(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getAllQuestions()
        gameManager = GameManager(questionsList, shared.getLevel(),shared.getCoin())
        loadViews()
        loadDataToView()
        binding.coin.text = "15"
        binding.coin.text = shared.getCoin().toString()
        binding.submit.setOnClickListener {
            if (check_()) {
                Toast.makeText(this, "Win", Toast.LENGTH_LONG).show()
                Thread.sleep(500)

                gameManager.level++
                gameManager.coins += 4

                var level_ = gameManager.level

                binding.coin.text = gameManager.coins.toString()
                binding.level.text = (++level_).toString()
                getAllQuestions()
                loadDataToView()
                string = ""
            } else {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getAllQuestions() {
        questionsList = ArrayList()
        questionsList.add(
            QuestionData(R.drawable.food,"food","fosasxovxd")
        )
        questionsList.add(
            QuestionData(R.drawable.book,"book","odfokqvbkv")
        )
        questionsList.add(
            QuestionData(R.drawable.black,"black","bdsldaxcfk")
        )
        questionsList.add(
            QuestionData(R.drawable.butter,"butter","vabstetaru")
        )
        questionsList.add(
            QuestionData(R.drawable.sport,"sport","btkdoptasr")
        )
        questionsList.add(
            QuestionData(R.drawable.king,"king","bnkdimnasg")
        )
        questionsList.add(
            QuestionData(R.drawable.pet,"pet","bnkpimnest")
        )
        questionsList.add(
            QuestionData(R.drawable.pen,"pen","bpkdimnase")
        )
        questionsList.add(
            QuestionData(R.drawable.money,"money","ynknimeaso")
        )
    }

    private fun loadViews() {
        imagesList = ArrayList()
//        for (i in 0 until binding.imagesLayout.childCount) {
//            imagesList.add(binding.imagesLayout.getChildAt(i) as ImageView)
//        }
//        binding.image
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

        binding.btnClear.setOnClickListener {
            clear()
        }

        binding.btnHelp.setOnClickListener {
            help()
        }
    }

    // Clear wordList
    fun check_(): Boolean {
        for (i in 0 until gameManager.getWordSize()) {
            string += wordList[i].text
        }
        return gameManager.check(string)
    }

    //Check
    fun clear() {
        for (i in 0 until gameManager.getWordSize()) {
            wordList[i].text = ""
        }
        string = ""
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
        binding.coin.text = gameManager.coins.toString()

//        for (i in 0 until imagesList.size) {
//            imagesList[i].setImageResource(gameManager.getQuestions()[i])
//        }
        binding.image.setImageResource(questionsList[gameManager.level].image)

        for (i in 0 until wordList.size) {
            if (gameManager.getWordSize() > i) {
                wordList[i].visible()
                wordList[i].text = ""
            } else {
                wordList[i].gone()
            }
        }

        for (i in 0 until lettersList.size) {
            lettersList[i].visible()
            lettersList[i].text = "${gameManager.getLetters()[i]}"
        }
    }

    fun help() {
        for (i in 0 until gameManager.getWordSize()) {
            if (wordList[i].text.isEmpty()) {
                wordList[i].text = gameManager.getWordLowercase()[i].toString()
                helpLetter(wordList[i])
                break
            }
        }
    }

    fun helpLetter(help: Button) {
        for (i in 0 until lettersList.size) {
            if (lettersList[i].text == help.text) {
                lettersList[i].invisible()
                break
            }
        }
    }

    override fun onStop() {
        shared.setLevel(gameManager.level)
        shared.setCoin(gameManager.coins)
        super.onStop()
    }
}