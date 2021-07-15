package com.example.zkouska.data

import kotlin.random.Random

data class ScoreItem(
    val number1: Int = Random.nextInt(0, 5),
    val number2: Int = Random.nextInt(0, 5),
    val nameOfTheSport : String = "Bowling",
    val nameOfTheTeam1 : String = "Hrusky",
    val nameOfTheTeam2 : String = "Jablka"
)
