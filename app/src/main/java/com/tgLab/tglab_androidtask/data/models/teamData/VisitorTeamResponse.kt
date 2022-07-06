package com.tgLab.tglab_androidtask.data.models.teamData

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VisitorTeamResponse(
    @Json(name = "abbreviation")
    val abbreviation: String?,
    @Json(name = "city")
    val city: String?,
    @Json(name = "conference")
    val conference: String?,
    @Json(name = "division")
    val division: String?,
    @Json(name = "full_name")
    val fullName: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?
)