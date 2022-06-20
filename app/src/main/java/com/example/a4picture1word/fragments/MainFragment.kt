package com.example.a4picture1word.fragments

import android.util.Log
import com.example.a4picture1word.controller.extensions
import com.example.a4picture1word.databinding.FragmentMainBinding
import com.example.a4picture1word.shared.Shared

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private val shared by lazy {
        Shared(requireContext())
    }

    override fun onViewCreated() {
        Log.d("EEE", "onCreate: ${shared.getSwitch()}")

        binding.btnPlay.setOnClickListener {
            extensions.controller?.replaceFragment(PlayFragment())
        }

        binding.btnInfo.setOnClickListener {
           extensions.controller?.replaceFragment(InfoFragment())
        }

        binding.btnSettings.setOnClickListener {
            extensions.controller?.replaceFragment(SettingsFragment())
        }

        binding.level.text = shared.getLevel().toString()
        Log.d("hhh", "onCreate: ${shared.getLevel()}")
        binding.coin.text = shared.getCoin().toString()

    }

}