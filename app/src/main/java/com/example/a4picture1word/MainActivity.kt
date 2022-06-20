package com.example.a4picture1word

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a4picture1word.controller.extensions
import com.example.a4picture1word.databinding.ActivityFragmentBinding
import com.example.a4picture1word.fragments.SplashFragment

class MainActivity : AppCompatActivity(){
    lateinit var binding : ActivityFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        extensions.init(R.id.container,supportFragmentManager)
        extensions.controller?.startMainFragment(SplashFragment())
    }
}