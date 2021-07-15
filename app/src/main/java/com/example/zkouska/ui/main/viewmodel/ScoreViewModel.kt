package com.example.zkouska.ui.main.viewmodel


import androidx.lifecycle.ViewModel
import com.example.zkouska.ui.main.adapter.ScoreAdapterView
import com.mikepenz.fastadapter.adapters.ItemAdapter

class ScoreViewModel : ViewModel() {

    val scoreAdapter =
        ItemAdapter<ScoreAdapterView>()




}