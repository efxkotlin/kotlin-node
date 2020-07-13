package com.efxcode.domain

import kotlin.js.Date

data class Project(val id:String, val name:String, val team:Team, val startDate: Date, val endDate: Date)

data class Team(
    val owner:String,
    val members: List<String>
)
