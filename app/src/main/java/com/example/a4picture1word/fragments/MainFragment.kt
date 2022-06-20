package com.example.a4picture1word.fragments

import android.util.Log
import com.example.a4picture1word.controller.extensions
import com.example.a4picture1word.databinding.FragmentMainBinding
import com.example.a4picture1word.shared.Shared

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private val shared by lazy {
        Shared(requireContext())
    }

//    override fun onBackPressed() {
//        AlertDialog.Builder(requireContext()).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
//            .setMessage("Are you sure?")
//            .setPositiveButton("yes", DialogInterface.OnClickListener { dialog, which ->
//                val intent = Intent(Intent.ACTION_MAIN)
//                intent.addCategory(Intent.CATEGORY_HOME)
//                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                startActivity(intent)
//            }).setNegativeButton("no", null).show()
//    }

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