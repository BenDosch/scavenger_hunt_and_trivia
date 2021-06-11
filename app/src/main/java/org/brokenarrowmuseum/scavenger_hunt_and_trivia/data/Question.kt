package org.brokenarrowmuseum.scavenger_hunt_and_trivia.data

import com.google.firebase.database.IgnoreExtraProperties

/**
 * Class representing questions for the scavenger hunt and trivia.
 */

@IgnoreExtraProperties
data class Question(
    var id: String? = null,
    var format: String? = "",
    var prompt: String? = "",
    var answers: MutableList<String>? = null,
    var category: String? = null,
    var picture: String? = null // Figure out what type of data later, string for now
)
