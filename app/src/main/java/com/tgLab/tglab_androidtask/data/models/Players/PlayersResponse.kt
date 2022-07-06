package com.tgLab.tglab_androidtask.data.models.Players

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlayersResponse(
    @Json(name = "data")
    val data: List<PlayersDataResponse>?,
)