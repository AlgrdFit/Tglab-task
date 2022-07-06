package com.tgLab.tglab_androidtask.data.repo

import android.util.Log
import com.tgLab.tglab_androidtask.data.models.Players.PlayersResponse
import com.tgLab.tglab_androidtask.data.models.teamData.TeamDataResponse
import com.tgLab.tglab_androidtask.data.models.teams.TeamsResponse
import com.tgLab.tglab_androidtask.network.NBAApi
import retrofit2.Response

class NBARepository(private val nbaApi: NBAApi) {

    suspend fun getTeams(): TeamsResponse?{
        return getTeamsApi().body()
    }
    suspend fun getPLayers(): PlayersResponse?{
        return getPLayersApi().body()
    }

    suspend fun getTeamData(teamIds: Int): TeamDataResponse?{
        return getTeamDataApi(teamIds).body()
    }

    private suspend fun getPLayersApi(playerName: String = ""): Response<PlayersResponse> {
        return nbaApi.getPlayers(playerName = playerName)
    }

    private suspend fun getTeamsApi(): Response<TeamsResponse> {
        return nbaApi.getTeams()
    }

    private suspend fun getTeamDataApi(teamIds: Int): Response<TeamDataResponse> {
        return nbaApi.getTeamData(teamIds = teamIds)
    }
}