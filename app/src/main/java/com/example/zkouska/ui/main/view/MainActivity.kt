package com.example.zkouska.ui.main.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.zkouska.R
import com.example.zkouska.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        title = "Menu"
        val settingIntent = Intent(this, SettingActivity::class.java)
        val scoreIntent = Intent(this, ScoreActivity::class.java)
        val bowlingIntent = Intent(this, BowlingPlayersActivity::class.java)
        val footballIntent = Intent(this, FootballActivity::class.java)

        binding.btnSetting.setOnClickListener {

            startActivityForResult(settingIntent, 1)
            setResult(0, intent)
            finish()
        }

        binding.btnScore.setOnClickListener {
            startActivityForResult(scoreIntent, 1)
            setResult(0, intent)
            finish()
        }
        binding.cardBowling.setOnClickListener {

            startActivityForResult(bowlingIntent, 1)

        }

        binding.cardView2.setOnClickListener {

            startActivityForResult(footballIntent, 1)
        }

    }
}