package com.tgLab.tglab_androidtask.network

import com.tgLab.tglab_androidtask.data.models.Players.PlayersResponse
import com.tgLab.tglab_androidtask.data.models.teamData.TeamDataResponse
import com.tgLab.tglab_androidtask.data.models.teams.TeamsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NBAApi {

    @GET("api/v1/teams")
    suspend fun getTeams(): Response<TeamsResponse>

    @GET("api/v1/games")
    suspend fun getTeamData(
        @Query("team_ids[]") teamIds: Int
    ): Response<TeamDataResponse>

    @GET("api/v1/players")
    suspend fun getPlayers(
        @Query("search") playerName: String
    ): Response<PlayersResponse>

    companion object {
        const val BASE_URL = "https://www.balldontlie.io"
    }
}