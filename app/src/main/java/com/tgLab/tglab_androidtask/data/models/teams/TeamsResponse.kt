package com.tgLab.tglab_androidtask.data.models.teams

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TeamsResponse(
    @Json(name = "data")
    val data: List<TeamsDataResponse>?,
)