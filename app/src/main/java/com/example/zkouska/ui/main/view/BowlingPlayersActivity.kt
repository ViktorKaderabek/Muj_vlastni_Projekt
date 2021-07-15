package com.example.zkouska.ui.main.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.zkouska.R
import com.example.zkouska.databinding.ActivityBowlingPlayersBinding


@Suppress("DEPRECATION")
class BowlingPlayersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityBowlingPlayersBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_bowling_players)

        title = "Bowling"
        val settingIntent = Intent(this, SettingActivity::class.java)
        val scoreIntent = Intent(this, ScoreActivity::class.java)
        val gamesIntent = Intent(this, MainActivity::class.java)
        val bowling2PlayersIntent = Intent(this, BowlingTwoPlayersActivity::class.java)

        binding.card2Players.setOnClickListener{

            startActivityForResult(bowling2PlayersIntent, 1)


        }

        binding.btnBack.setOnClickListener {

            setResult(0, intent)
            finish()
        }

        binding.btnGames.setOnClickListener {

            startActivityForResult(gamesIntent, 1)
            setResult(0, intent)
            finish()
        }

        binding.btnScore.setOnClickListener {

            startActivityForResult(scoreIntent, 1)
            setResult(0, intent)
            finish()
        }

        binding.btnSetting.setOnClickListener {

            startActivityForResult(settingIntent, 1)
            setResult(0, intent)
            finish()
        }

    }
}