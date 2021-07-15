package com.example.zkouska.ui.main.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.zkouska.R
import com.example.zkouska.data.ScoreItem
import com.example.zkouska.databinding.ScoreLookBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class ScoreAdapterView(private val score: ScoreItem) :
    AbstractBindingItem<ScoreLookBinding>() { //Do promenne place vkladam tridu Place, ktera obsahuje prommenne ktere pripojim k realnym viewckum

    override val type: Int
        get() = R.id.score_item

    override fun bindView(binding: ScoreLookBinding, payloads: List<Any>) {

        val number1: Int = score.number1
        val number2: Int = score.number2

        binding.number1.text = score.number1.toString()
        binding.number2.text = score.number2.toString()
        binding.nameOfTheTeam1.text = score.nameOfTheTeam1
        binding.nameOfTheTeam2.text = score.nameOfTheTeam2
        binding.nameOfTheSport.text = score.nameOfTheSport


        if (number1 > number2) {
            binding.scoreBackground.setBackgroundColor(Color.parseColor("#a5f2a2"))
        } else if (number1 < number2) {
            binding.scoreBackground.setBackgroundColor(Color.parseColor("#ed8c9f"))
        } else if (number1 == number2) {
            binding.scoreBackground.setBackgroundColor(Color.parseColor("#949191"))
        }
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ScoreLookBinding {
        return ScoreLookBinding.inflate(inflater, parent, false)

    }
}