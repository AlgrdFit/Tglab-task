package com.tgLab.tglab_androidtask.ui.players

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tgLab.tglab_androidtask.data.models.Players.PlayersResponse
import com.tgLab.tglab_androidtask.data.repo.NBARepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayersViewModel(private val nbaRepository: NBARepository) : ViewModel() {

    private val _players = MutableLiveData<PlayersResponse>()
    fun players(): LiveData<PlayersResponse> = _players

    fun getPlayers(){
        viewModelScope.launch(Dispatchers.IO) {
            val data = nbaRepository.getPLayers()
            if (data != null) {
                _players.postValue(data)
            }
        }
    }
}