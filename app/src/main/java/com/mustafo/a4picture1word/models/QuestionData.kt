package com.mustafo.a4picture1word.models

//@Entity(tableName = "questionData")
data class QuestionData(
//    @PrimaryKey(autoGenerate = true)
//    var id:Int = 0,
    var image: Int,
    var word: String,
    var letters: String
)