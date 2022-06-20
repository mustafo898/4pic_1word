package com.example.a4picture1word.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import com.example.a4picture1word.R
import com.example.a4picture1word.controller.extensions
import com.example.a4picture1word.databinding.FragmentPlayBinding
import com.example.a4picture1word.managers.GameManager
import com.example.a4picture1word.managers.Questions
import com.example.a4picture1word.models.QuestionData
import com.example.a4picture1word.shared.Shared
import com.example.a4picture1word.utils.*
import com.thecode.aestheticdialogs.AestheticDialog
import com.thecode.aestheticdialogs.DialogAnimation
import com.thecode.aestheticdialogs.DialogStyle
import com.thecode.aestheticdialogs.DialogType

class PlayFragment : BaseFragment<FragmentPlayBinding>(FragmentPlayBinding::inflate) {
    lateinit var imagesList: ArrayList<ImageView>
    lateinit var wordList: ArrayList<AppCompatButton>
    lateinit var lettersList: ArrayList<AppCompatButton>
    lateinit var gameManager: GameManager
    private val question by lazy {
        Questions()
    }
    var string = ""

    private val shared by lazy {
        Shared(requireContext())
    }

    override fun onViewCreated() {
        gameManager = GameManager(question.getQuestions(), shared.getLevel(), shared.getCoin(),shared.getHelper())
        Log.d("ssss", "onCreate: ${shared.getLevel()}  ${shared.getHelper()}  ${shared.getCoin()}")

        loadViews()
        loadDataToView()

        binding.coin.text = shared.getCoin().toString()
        binding.level.text = gameManager.level.toString()
        binding.btnBack.setOnClickListener {
            extensions.controller?.startMainFragment(MainFragment())
        }

        binding.btnClear.setOnClickListener {
            clear()
        }

        binding.btnHelp.setOnClickListener {
            if (gameManager.help >= 1){
                binding.btnHelp.setImageResource(R.drawable.ic_help)
            }else if (gameManager.help == 0){
                binding.btnHelp.setImageResource(R.drawable.ic_coins)
            }

            if (gameManager.help <= 0){
                if (gameManager.coins >= 4){
                    gameManager.coins-=4
                    binding.coin.text = gameManager.coins.toString()
                    shared.setHelper(gameManager.help)
                    shared.setCoin(gameManager.coins)
                    help()
                }else{
                    Toast.makeText(requireContext(), "Don't enough coins", Toast.LENGTH_SHORT).show()
                }
            }else if(gameManager.help >= 0){
                gameManager.help-=1
                help()
            }
        }
    }

    private fun loadViews() {
        imagesList = ArrayList()

        wordList = ArrayList()
        for (i in 0 until binding.wordLayout.childCount) {
            wordList.add(binding.wordLayout.getChildAt(i) as AppCompatButton)
            wordList[i].setOnClickListener {
                wordBtnClick(it as Button)

            }
        }

        lettersList = ArrayList()

        for (i in 0 until binding.letterLayout.childCount) {
            lettersList.add(binding.letterLayout.getChildAt(i) as AppCompatButton)
            lettersList[i].setOnClickListener {
                string =""
                letterBtnClick(it as Button)
                check()
            }
        }
    }

    private fun clear() {
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
            val word = button.text.toString()
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
    }

    private fun loadDataToView() {
        if (gameManager.level < question.getQuestions().size){
            shared.setLevel(gameManager.level)
            shared.setCoin(gameManager.coins)
            shared.setHelper(gameManager.help)
            binding.coin.text = gameManager.coins.toString()
            binding.level.text = gameManager.level.toString()

            binding.image.setImageResource(question.getQuestions()[gameManager.level].image)

            if (gameManager.help >= 1){
                binding.btnHelp.setImageResource(R.drawable.ic_help)
            }else if (gameManager.help == 0){
                binding.btnHelp.setImageResource(R.drawable.ic_coins)
            }

            string = ""
            for (i in 0 until wordList.size) {
                if (gameManager.getWordSize() > i) {
                    wordList[i].visible()
                    wordList[i].text = ""
                } else {
                    wordList[i].gone()
                }
            }

            if (gameManager.level%9 == 0){
                gameManager.help+=5
            }

            for (i in 0 until lettersList.size) {
                lettersList[i].visible()
                lettersList[i].text = "${gameManager.getLetters()[i]}"
            }
        }else{
            Toast.makeText(requireContext(), "Congratulated you passed this game", Toast.LENGTH_SHORT).show()
            extensions.controller?.startMainFragment(MainFragment())
        }
    }

    private fun help() {
        var n = 0
        var s = false
        string = ""
        for (i in 0 until wordList.size) {
            if(gameManager.getWordSize() > i){
                if (wordList[i].text.isEmpty()){
                    n = i
                    wordList[i].text = gameManager.getWord()[i].toString()
                    s = true
                    break
                }
            }
            if (s){
                break
            }
        }

        for (i in 0 until lettersList.size){
            if (wordList[n].text.toString() == lettersList[i].text.toString()){
                lettersList[i].invisible()
                break
            }
        }
        check()
    }

    private fun check(){
        for (j in 0 until wordList.size){
            if (gameManager.getWordSize() > j){
                string+=wordList[j].text
            }
        }
        if (string == gameManager.getWord()){
            Log.d("aaa", "loadViews: $string")
            winDialogShow()
            gameManager.coins+=4
            gameManager.level+=1
            loadDataToView()
            binding.coin.text = gameManager.coins.toString()
            binding.level.text = gameManager.level.toString()
        }else if (string.length == gameManager.getWordSize() && string != gameManager.getWord()){
            errorDialogShow()
        }
    }

    private fun winDialogShow() {
        val builder: AestheticDialog.Builder =
            AestheticDialog.Builder(
                requireActivity(),
                DialogStyle.EMOTION,
                DialogType.SUCCESS
            );
        builder.setTitle("CORRECT")
        builder.setMessage("ANSWER : ${gameManager.getWord()}")
        builder.setAnimation(DialogAnimation.IN_OUT);
        builder.show()
    }

    private fun errorDialogShow() {
        val builder: AestheticDialog.Builder =
            AestheticDialog.Builder(
                requireActivity(),
                DialogStyle.EMOTION,
                DialogType.ERROR
            );
        builder.setTitle("INCORRECT")
        builder.setMessage(string.uppercase())
        builder.setAnimation(DialogAnimation.IN_OUT);
        builder.show()
    }

    override fun onDestroy() {
        shared.setCoin(gameManager.coins)
        shared.setLevel(gameManager.level)
        shared.setHelper(gameManager.help)
        super.onDestroy()
    }
}