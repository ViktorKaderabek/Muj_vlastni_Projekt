package com.example.zkouska.ui.main.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.zkouska.R
import com.example.zkouska.data.ScoreItem
import com.example.zkouska.databinding.ActivityFootballBinding
import com.example.zkouska.ui.main.adapter.ScoreAdapterView
import com.example.zkouska.ui.main.viewmodel.FootballViewModel
import com.example.zkouska.ui.main.viewmodel.ScoreViewModel

@Suppress("DEPRECATION")
class FootballActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityFootballBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_football)

        title = "Football"
        val settingIntent = Intent(this, SettingActivity::class.java)
        val scoreIntent = Intent(this, ScoreActivity::class.java)
        val gamesIntent = Intent(this, MainActivity::class.java)
        val scoreViewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        val footballViewModel = ViewModelProvider(this).get(FootballViewModel::class.java)
        val number1 : Int = footballViewModel.getTeam1Counter().value!!.toInt()

        binding.team1Increase.setOnClickListener {

            footballViewModel.team1Increase()
            footballViewModel.getTeam1Counter()
                .observe(this, Observer { binding.txtTeam1Counter.text = it.toString() })

        }

        binding.team1Remove.setOnClickListener {

            footballViewModel.team1Remove()
            footballViewModel.getTeam1Counter()
                .observe(this, Observer { binding.txtTeam1Counter.text = it.toString() })

        }

        binding.team2Increase.setOnClickListener {

            footballViewModel.team2Increase()
            footballViewModel.getTeam2Counter()
                .observe(this, Observer { binding.txtTeam2Counter.text = it.toString() })

        }

        binding.team2Remove.setOnClickListener {

            footballViewModel.team2Remove()
            footballViewModel.getTeam2Counter()
                .observe(this, Observer { binding.txtTeam2Counter.text = it.toString() })

        }

        binding.btnAgain.setOnClickListener {

            footballViewModel.removeAll()
            footballViewModel.getTeam1Counter()
                .observe(this, Observer { binding.txtTeam1Counter.text = it.toString() })
            footballViewModel.getTeam2Counter()
                .observe(this, Observer { binding.txtTeam2Counter.text = it.toString() })
        }

        binding.btnFinish.setOnClickListener {

            scoreViewModel.scoreAdapter.add(
                ScoreAdapterView(
                    ScoreItem(
                        number1 = footballViewModel.getTeam1Counter().value!!.toInt(),
                        number2 = footballViewModel.getTeam2Counter().value!!.toInt()
                    )
                )
            )

            footballViewModel.removeAll()
            startActivityForResult(scoreIntent, 1)
            setResult(0, intent)
            finish()

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