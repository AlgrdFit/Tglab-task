package com.tgLab.tglab_androidtask.data.models.teamData

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TeamDataDataResponse(
    @Json(name = "date")
    val date: String?,
    @Json(name = "home_team")
    val homeTeam: HomeTeamResponse?,
    @Json(name = "home_team_score")
    val homeTeamScore: Int?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "period")
    val period: Int?,
    @Json(name = "postseason")
    val postseason: Boolean?,
    @Json(name = "season")
    val season: Int?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "time")
    val time: String?,
    @Json(name = "visitor_team")
    val visitorTeam: VisitorTeamResponse?,
    @Json(name = "visitor_team_score")
    val visitorTeamScore: Int?
)