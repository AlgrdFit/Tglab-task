package com.tgLab.tglab_androidtask.data.models.teamData

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TeamDataResponse(
    @Json(name = "data")
    val data: List<TeamDataDataResponse>?
)