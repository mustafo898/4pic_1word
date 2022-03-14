package com.example.a4picture1word

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a4picture1word.databinding.ActivityMainBinding
import com.example.a4picture1word.shared.Shared

class MainActivity : AppCompatActivity() {
    val shared by lazy {
        Shared(this)
    }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // dialogni shunday qo'yib keting
        binding.btnPlay.setOnClickListener {
            finish()
            var intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }
        binding.coin.text = "${shared.getCoin()}"
    }
}