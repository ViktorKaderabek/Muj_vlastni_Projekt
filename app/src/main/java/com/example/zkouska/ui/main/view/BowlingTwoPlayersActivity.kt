package com.example.zkouska.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.zkouska.R
import com.example.zkouska.databinding.ActivityBowlingTwoPlayersBinding
@Suppress("DEPRECATION")
class BowlingTwoPlayersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityBowlingTwoPlayersBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_bowling_two_players
        )

        title = "Bowling"
        val settingIntent = Intent(this, SettingActivity::class.java)
        val scoreIntent = Intent(this, ScoreActivity::class.java)
        val gamesIntent = Intent(this, MainActivity::class.java)

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