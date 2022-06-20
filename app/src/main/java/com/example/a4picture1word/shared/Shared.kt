package com.example.a4picture1word.shared

import android.content.Context
import android.content.SharedPreferences
import java.util.ArrayList

class Shared(context:Context) {

    private var preferences: SharedPreferences =
        context.getSharedPreferences("APP_PREFS_NAME", Context.MODE_PRIVATE)

    private lateinit var editor: SharedPreferences.Editor

    fun setLevel(level:Int){
        editor = preferences.edit()
        editor.putInt("LEVEL",level)
        editor.apply()
    }

    fun getSwitch() = preferences.getBoolean("SWITCH",true)

    fun setSwitch(switch:Boolean){
        editor = preferences.edit()
        editor.putBoolean("SWITCH",switch)
        editor.apply()
    }

    fun getLevel() = preferences.getInt("LEVEL",1)

    fun setCoin(coin:Int){
        editor = preferences.edit()
        editor.putInt("COIN",coin)
        editor.apply()
    }

    fun getCoin() = preferences.getInt("COIN",60)

    fun setHelper(helper:Int){
        editor = preferences.edit()
        editor.putInt("HELP",helper)
        editor.apply()
    }

    fun getHelper() = preferences.getInt("HELP",5)
}