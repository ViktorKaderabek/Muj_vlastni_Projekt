package com.example.zkouska.ui.main.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zkouska.R
import com.example.zkouska.data.ScoreItem
import com.example.zkouska.databinding.ActivityScoreBinding
import com.example.zkouska.ui.main.adapter.ScoreAdapterView
import com.example.zkouska.ui.main.viewmodel.ScoreViewModel
import com.mikepenz.fastadapter.FastAdapter


@Suppress("DEPRECATION")
class ScoreActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityScoreBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_score)

        title = "Match history"

        val gamesIntent = Intent(this, MainActivity::class.java)
        val scoreViewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        val settingIntent = Intent(this, SettingActivity::class.java)
        val fastAdapter =
            FastAdapter.with(scoreViewModel.scoreAdapter)
        // val getScoreLook: ScoreLookBinding = ScoreLookBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = fastAdapter // Nastavuje recyclerview co bude obsahem
        binding.recyclerView.setHasFixedSize(true)

        binding.btnGames.setOnClickListener {

            startActivityForResult(gamesIntent, 1)
            setResult(0, intent)
            finish()
        }

        binding.btnScore.setOnClickListener {

            scoreViewModel.scoreAdapter.add(ScoreAdapterView(ScoreItem()))
        }

        binding.btnSetting.setOnClickListener {

            startActivityForResult(settingIntent, 1)
            setResult(0, intent)
            finish()
        }
    }
}