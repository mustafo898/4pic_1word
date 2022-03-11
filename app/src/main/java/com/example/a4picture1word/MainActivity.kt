package com.example.a4picture1word

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a4picture1word.databinding.ActivityMainBinding
import com.thecode.aestheticdialogs.AestheticDialog
import com.thecode.aestheticdialogs.DialogAnimation
import com.thecode.aestheticdialogs.DialogStyle
import com.thecode.aestheticdialogs.DialogType

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlay.setOnClickListener {
            finish()
            var intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }

        binding.btnSettings.setOnClickListener {
            WinDialogShow()
        }

    }

    fun WinDialogShow() {
        var builder: AestheticDialog.Builder =
            AestheticDialog.Builder(
                this,
                DialogStyle.EMOTION,
                DialogType.SUCCESS
            );

        // title
        builder.setTitle("CORRECT")

        // message
        builder.setMessage("Tap anywhere to continue")

        // dialog animation
        builder.setAnimation(DialogAnimation.IN_OUT);
        builder.show()

        // dialogStyle:
        /* FLASH, CONNECTIFY, TOASTER, EMOJI, EMOTION, DRAKE, RAINBOW, FLAT*/

        // dialog animations:
        /* FADE, CARD, DEFAULT, DIAGONAL, IN_OUT, SHRINK, SLIDE_DOWN, SLIDE_LEFT
        SLIDE_RIGHT SLIDE_UP SPIN SPLIT SWIPE_LEFT SWIPE_RIGHT WINDMILL ZOOM*/
    }
}