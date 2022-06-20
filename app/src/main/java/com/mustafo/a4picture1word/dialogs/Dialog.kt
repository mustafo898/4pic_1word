package com.mustafo.a4picture1word.dialogs

import android.app.Activity
import android.content.Context
import com.thecode.aestheticdialogs.AestheticDialog
import com.thecode.aestheticdialogs.DialogStyle
import com.thecode.aestheticdialogs.DialogType

data class Dialog(var context: Context, var title: String, var message: String) {

        var builder: AestheticDialog.Builder =
            AestheticDialog.Builder(
                context as Activity,
                DialogStyle.EMOTION,
                DialogType.ERROR
            );

//        // title
//        builder.setTitle(title)
//
//        // message
//        builder.setMessage(message)
//
//        // dialog animation
//        builder.setAnimation(DialogAnimation.IN_OUT);
//        builder.show()

        // dialogStyle:
        /* FLASH, CONNECTIFY, TOASTER, EMOJI, EMOTION, DRAKE, RAINBOW, FLAT*/

        // dialog animations:
        /* FADE, CARD, DEFAULT, DIAGONAL, IN_OUT, SHRINK, SLIDE_DOWN, SLIDE_LEFT
        SLIDE_RIGHT SLIDE_UP SPIN SPLIT SWIPE_LEFT SWIPE_RIGHT WINDMILL ZOOM*/

}