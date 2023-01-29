package com.example.android11lesson6dz.repository

import com.example.android11lesson6dz.data.TextModel
import com.example.android1lesson6dz.databinding.FragmentFirstBinding

class TextRepository {
    private var textList = mutableListOf<TextModel>()

    fun getListOfText(): MutableList<TextModel> {
        textList.add(TextModel("kjfdls"))
        textList.add(TextModel("kjfdls2"))
        textList.add(TextModel("kjfdls3"))
        textList.add(TextModel("kjfdls4"))
        textList.add(TextModel("kjfdls5"))
        textList.add(TextModel("kjfdls6"))
        textList.add(TextModel("kjfdls7"))
        textList.add(TextModel("kjfdls8"))
        textList.add(TextModel("kjfdls9"))
        textList.add(TextModel("kjfdls10"))
        textList.add(TextModel("kjfdls11"))
        textList.add(TextModel("kjfdls12"))
        textList.add(TextModel("kjfdls13"))
        textList.add(TextModel("kjfdls14"))
        textList.add(TextModel("kjfdls15"))
        textList.add(TextModel("kjfdls16"))
        textList.add(TextModel("kjfdls17"))
        textList.add(TextModel("kjfdls18"))
        return textList
    }
}