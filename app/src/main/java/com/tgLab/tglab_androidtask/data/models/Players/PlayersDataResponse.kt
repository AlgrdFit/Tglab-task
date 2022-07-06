package com.tgLab.tglab_androidtask.data.models.Players

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlayersDataResponse(
    @Json(name = "first_name")
    val firstName: String?,
    @Json(name = "height_feet")
    val heightFeet: Int?,
    @Json(name = "height_inches")
    val heightInches: Int?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "last_name")
    val lastName: String?,
    @Json(name = "position")
    val position: String?,
    @Json(name = "team")
    val team: PlayersTeamResponse?,
    @Json(name = "weight_pounds")
    val weightPounds: Int?
)