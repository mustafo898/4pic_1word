package com.example.a4picture1word.app

import android.app.Application
import com.example.a4picture1word.R

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Media.getInstance()
        Media.media?.play(applicationContext, R.raw.gamemusic)
    }
}