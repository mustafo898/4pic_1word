package com.example.a4picture1word.models

import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "questionData")
data class QuestionData(
//    @PrimaryKey(autoGenerate = true)
//    var id:Int = 0,
    var image: Int,
    var word: String,
    var letters: String
)