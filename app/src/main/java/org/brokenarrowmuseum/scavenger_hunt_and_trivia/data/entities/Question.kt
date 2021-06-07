package org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.entities

import com.google.firebase.database.IgnoreExtraProperties

/**
 * Class representing questions for the scavenger hunt and trivia.
 */

@IgnoreExtraProperties
data class Question(
    val id: Int = 0,
    var format: String = "",
    var prompt: String = "",
    var answers: MutableList<String> = mutableListOf(),
    var category: String = "",
    var picture: String = "" // Figure out what type of data later, string for now
)
