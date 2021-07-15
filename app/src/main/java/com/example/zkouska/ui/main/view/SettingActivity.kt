package com.example.zkouska.ui.main.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.zkouska.R
import com.example.zkouska.databinding.ActivitySettingBinding

@Suppress("DEPRECATION")
class SettingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySettingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_setting)

        title = "Setting"
        val gamesIntent = Intent(this, MainActivity::class.java)
        val scoreIntent = Intent(this, ScoreActivity::class.java)

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


    }
}