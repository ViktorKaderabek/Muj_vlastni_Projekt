package com.example.zkouska.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class FootballViewModel : ViewModel() {


    private var _team1Counter: Int = 0
    private var _team2Counter: Int = 0
    private var team1Counter = MutableLiveData<Int>()
    private var team2Counter = MutableLiveData<Int>()

    fun team1Increase(): Int {

        _team1Counter += 1

        return _team1Counter

    }

    fun team1Remove(): Int {

        _team1Counter -= 1

        return _team1Counter

    }

    fun team2Increase(): Int {

        _team2Counter += 1

        return _team1Counter

    }

    fun team2Remove(): Int {

        _team2Counter -= 1

        return _team1Counter

    }

    fun getTeam1Counter() : LiveData<Int>{

        team1Counter.value = _team1Counter

        return team1Counter

    }

    fun getTeam2Counter() : LiveData<Int>{

        team2Counter.value = _team2Counter

        return team2Counter

    }

    fun removeAll() {

        _team1Counter = 0

        _team2Counter = 0


    }


}