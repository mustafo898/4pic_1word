package com.example.a4picture1word.fragments

import android.annotation.SuppressLint
import android.os.Handler
import android.view.View
import com.example.a4picture1word.controller.extensions
import com.example.a4picture1word.databinding.FragmentSplashBinding

@SuppressLint("CustomSplashScreen")
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    private var i = 0
    private val handler = Handler()

//    private fun startTimer() {
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )
//        Handler().postDelayed({
//
//        }, 3000)
//    }

    // progress barni ishlab turishi uchun
    private fun progress () {
        i = binding.progressBar.progress
        Thread {
            while (i < 100) {
                i += 1
                handler.post {
                    binding.progressBar.progress = i
                }
                try {
                    Thread.sleep(50)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            binding.progressBar.visibility = View.INVISIBLE
            extensions.controller?.startMainFragment(MainFragment())
        }.start()
    }

    override fun onViewCreated() {
        progress()
    }
}