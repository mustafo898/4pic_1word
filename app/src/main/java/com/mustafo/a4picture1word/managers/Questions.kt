package com.mustafo.a4picture1word.managers

import android.util.Log
import com.mustafo.a4picture1word.R
import com.mustafo.a4picture1word.models.QuestionData

class Questions {
    private val questionsList = ArrayList<QuestionData>()

    fun getQuestions(): ArrayList<QuestionData> {
        questionsList.add(QuestionData(R.drawable.bud,"bud",shuffleWord("show")))
        questionsList.add(QuestionData(R.drawable.pet,"pet",shuffleWord("pet")))
        questionsList.add(QuestionData(R.drawable.show,"show",shuffleWord("show")))
        questionsList.add(QuestionData(R.drawable.side,"side",shuffleWord("side")))
        questionsList.add(QuestionData(R.drawable.sign,"sign",shuffleWord("sign")))
        questionsList.add(QuestionData(R.drawable.sing,"sing",shuffleWord("sing")))
        questionsList.add(QuestionData(R.drawable.site,"site",shuffleWord("site")))
        questionsList.add(QuestionData(R.drawable.sink,"sink",shuffleWord("sink")))
        questionsList.add(QuestionData(R.drawable.silk,"silk",shuffleWord("silk")))
        questionsList.add(QuestionData(R.drawable.skin,"skin",shuffleWord("skin")))
        questionsList.add(QuestionData(R.drawable.slim,"slim",shuffleWord("slim")))
        questionsList.add(QuestionData(R.drawable.snap,"snap",shuffleWord("snap")))
        questionsList.add(QuestionData(R.drawable.snag,"snag",shuffleWord("snag")))
        questionsList.add(QuestionData(R.drawable.slow,"slow",shuffleWord("slow")))
        questionsList.add(QuestionData(R.drawable.snow,"snow",shuffleWord("snow")))
        questionsList.add(QuestionData(R.drawable.snip,"snip",shuffleWord("snip")))
        questionsList.add(QuestionData(R.drawable.soak,"soak",shuffleWord("soak")))
        questionsList.add(QuestionData(R.drawable.soap,"soap",shuffleWord("soap")))
        questionsList.add(QuestionData(R.drawable.soar,"soar",shuffleWord("soar")))
        questionsList.add(QuestionData(R.drawable.sock,"sock",shuffleWord("sock")))
        questionsList.add(QuestionData(R.drawable.sofa,"sofa",shuffleWord("sofa")))
        questionsList.add(QuestionData(R.drawable.soft,"soft",shuffleWord("soft")))
        questionsList.add(QuestionData(R.drawable.sole,"sole",shuffleWord("sole")))
        questionsList.add(QuestionData(R.drawable.solo,"solo",shuffleWord("solo")))
        questionsList.add(QuestionData(R.drawable.tick,"tick",shuffleWord("tick")))
        questionsList.add(QuestionData(R.drawable.tile,"tile",shuffleWord("tile")))
        questionsList.add(QuestionData(R.drawable.till,"till",shuffleWord("till")))
        questionsList.add(QuestionData(R.drawable.time,"time",shuffleWord("time")))
        questionsList.add(QuestionData(R.drawable.tiny,"tiny",shuffleWord("tiny")))
        questionsList.add(QuestionData(R.drawable.toad,"toad",shuffleWord("toad")))
        questionsList.add(QuestionData(R.drawable.toes,"toes",shuffleWord("toes")))
        questionsList.add(QuestionData(R.drawable.tofu,"tofu",shuffleWord("tofu")))
        questionsList.add(QuestionData(R.drawable.tool,"tool",shuffleWord("tool")))
        questionsList.add(QuestionData(R.drawable.town,"town",shuffleWord("town")))
        questionsList.add(QuestionData(R.drawable.toys,"toys",shuffleWord("toys")))
        questionsList.add(QuestionData(R.drawable.tram,"tram",shuffleWord("tram")))
        questionsList.add(QuestionData(R.drawable.trap,"trap",shuffleWord("trap")))
        questionsList.add(QuestionData(R.drawable.tray,"tray",shuffleWord("tray")))
        questionsList.add(QuestionData(R.drawable.tuna,"tuna",shuffleWord("tuna")))
        questionsList.add(QuestionData(R.drawable.turn,"turn",shuffleWord("turn")))
        questionsList.add(QuestionData(R.drawable.twig,"twig",shuffleWord("twig")))
        questionsList.add(QuestionData(R.drawable.type,"type",shuffleWord("type")))
        questionsList.add(QuestionData(R.drawable.unit,"unit",shuffleWord("unit")))
        questionsList.add(QuestionData(R.drawable.vase,"vase",shuffleWord("vase")))
        questionsList.add(QuestionData(R.drawable.veil,"veil",shuffleWord("veil")))
        questionsList.add(QuestionData(R.drawable.vein,"vein",shuffleWord("vein")))
        questionsList.add(QuestionData(R.drawable.vest,"vest",shuffleWord("vest")))
        questionsList.add(QuestionData(R.drawable.view,"view",shuffleWord("view")))
        questionsList.add(QuestionData(R.drawable.voids,"void",shuffleWord("void")))
        questionsList.add(QuestionData(R.drawable.wait,"wait",shuffleWord("wait")))
        questionsList.add(QuestionData(R.drawable.walk,"walk",shuffleWord("walk")))
        questionsList.add(QuestionData(R.drawable.wall,"wall",shuffleWord("wall")))
        questionsList.add(QuestionData(R.drawable.warm,"warm",shuffleWord("warm")))
        questionsList.add(QuestionData(R.drawable.wash,"wash",shuffleWord("wash")))
        questionsList.add(QuestionData(R.drawable.wave,"wave",shuffleWord("wave")))
        questionsList.add(QuestionData(R.drawable.wavy,"wavy",shuffleWord("wavy")))
        questionsList.add(QuestionData(R.drawable.weak,"weak",shuffleWord("weak")))
        questionsList.add(QuestionData(R.drawable.week,"week",shuffleWord("week")))
        questionsList.add(QuestionData(R.drawable.wide,"wide",shuffleWord("wide")))
        questionsList.add(QuestionData(R.drawable.wife,"wife",shuffleWord("wife")))
        questionsList.add(QuestionData(R.drawable.wind,"wind",shuffleWord("wind")))
        questionsList.add(QuestionData(R.drawable.wipe,"wipe",shuffleWord("wipe")))
        questionsList.add(QuestionData(R.drawable.wire,"wire",shuffleWord("wire")))
        questionsList.add(QuestionData(R.drawable.wish,"wish",shuffleWord("wish")))
        questionsList.add(QuestionData(R.drawable.wolf,"wolf",shuffleWord("wolf")))
        questionsList.add(QuestionData(R.drawable.wood,"wood",shuffleWord("wood")))
        questionsList.add(QuestionData(R.drawable.work,"work",shuffleWord("work")))
        questionsList.add(QuestionData(R.drawable.worm,"worm",shuffleWord("worm")))
        questionsList.add(QuestionData(R.drawable.wrap,"wrap",shuffleWord("wrap")))
        questionsList.add(QuestionData(R.drawable.yarn,"yarn",shuffleWord("yarn")))
        questionsList.add(QuestionData(R.drawable.yawn,"yawn",shuffleWord("yawn")))
        questionsList.add(QuestionData(R.drawable.yolk,"yolk",shuffleWord("yolk")))
        questionsList.add(QuestionData(R.drawable.zero,"zero",shuffleWord("zero")))
        questionsList.add(QuestionData(R.drawable.zeus,"zeus",shuffleWord("zeus")))
        questionsList.add(QuestionData(R.drawable.zoom,"zoom",shuffleWord("zoom")))

//        questionsList.shuffle()
        return questionsList
    }

    private fun shuffleWord(word:String):String {
        val s = word.uppercase()
        val charArray = ArrayList<Char>()

        for (i in s.indices){
            charArray.add(s[i])
        }

        for (i in 0 until 10-charArray.size){
            charArray.add(('A'..'Z').random())
        }

        charArray.shuffle()

        var resultWord = ""
        for (i in 0 until charArray.size){
            resultWord+=charArray[i]
        }
        Log.d("ggggg", "shuffleWord: $resultWord")
        Log.d("ggggg", "shuffleWord: $charArray")
        return resultWord.uppercase()
    }
}