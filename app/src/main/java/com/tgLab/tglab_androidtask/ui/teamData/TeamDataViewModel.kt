package com.tgLab.tglab_androidtask.ui.teamData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tgLab.tglab_androidtask.data.models.teamData.TeamDataResponse
import com.tgLab.tglab_androidtask.data.repo.NBARepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TeamDataViewModel(private val nbaRepository: NBARepository) : ViewModel() {

    private val _teamData = MutableLiveData<TeamDataResponse>()
    fun teamData(): LiveData<TeamDataResponse> = _teamData

    fun getTeamData(teamIds: Int){
        viewModelScope.launch(Dispatchers.IO) {
            val data = nbaRepository.getTeamData(teamIds)
            if (data != null) {
                _teamData.postValue(data)
            }
        }
    }
}