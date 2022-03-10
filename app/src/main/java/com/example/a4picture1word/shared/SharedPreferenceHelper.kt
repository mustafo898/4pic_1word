package com.example.a4picture1word.shared

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceHelper(var context: Context) {

    companion object{
        const val LEVEL_IN_GAME = "LEVEL_IN_GAME"
    }

    private var preferences: SharedPreferences =
        context.getSharedPreferences("APP_PREFS_NAME", Context.MODE_PRIVATE)

    private lateinit var editor: SharedPreferences.Editor

    fun setLevel(level: Int){
        editor = preferences.edit()
        editor.putInt(LEVEL_IN_GAME, level)
        editor.apply()
    }

    fun getLevel() = preferences.getInt(LEVEL_IN_GAME,1)


}