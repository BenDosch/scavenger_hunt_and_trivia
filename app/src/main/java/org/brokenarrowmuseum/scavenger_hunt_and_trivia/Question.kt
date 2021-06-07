package org.brokenarrowmuseum.scavenger_hunt_and_trivia

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Question(
    val id : String = "",
    var format: String = "",
    var prompt: String = "",
    var answers: MutableList<String> = mutableListOf(),
    var category: String = "",
    var picture: String = "" // Figure out what type of data later, string for now
)
