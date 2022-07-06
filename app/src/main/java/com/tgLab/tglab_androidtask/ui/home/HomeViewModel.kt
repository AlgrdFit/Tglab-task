package com.tgLab.tglab_androidtask.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tgLab.tglab_androidtask.data.models.teams.TeamsResponse
import com.tgLab.tglab_androidtask.data.repo.NBARepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val nbaRepository: NBARepository) : ViewModel() {

    private val _teams = MutableLiveData<TeamsResponse>()
    fun teams(): LiveData<TeamsResponse> = _teams

    fun getTeams(){
         viewModelScope.launch(Dispatchers.IO) {
             val data = nbaRepository.getTeams()
             if (data != null) {
                 _teams.postValue(data)
             }
        }
    }
}