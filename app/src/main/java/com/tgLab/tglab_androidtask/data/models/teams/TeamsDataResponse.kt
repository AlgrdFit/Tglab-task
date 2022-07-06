package com.tgLab.tglab_androidtask.data.models.teams

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TeamsDataResponse(
    @Json(name = "abbreviation")
    val abbreviation: String?,
    @Json(name = "city")
    val city: String?,
    @Json(name = "conference")
    val conference: String?,
    @Json(name = "division")
    val division: String?,
    @Json(name = "full_name")
    val full_name: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?
)