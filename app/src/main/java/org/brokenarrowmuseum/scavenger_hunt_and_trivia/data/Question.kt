package org.brokenarrowmuseum.scavenger_hunt_and_trivia.data

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

/**
 * Class representing questions for the scavenger hunt and trivia.
 */

@IgnoreExtraProperties
data class Question(
    @get: Exclude
    var id: String? = null,
    @get: Exclude
    var isDeleted: Boolean = false,
    var format: String? = "",
    var prompt: String? = "",
    var answers: MutableList<String>? = null,
    var category: String? = null,
    var picture: String? = null // Figure out what type of data later, string for now
) {
    override fun equals(other: Any?): Boolean {
        return if (other is Question) {
            other.id == id
        } else {
            return false
        }
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (format?.hashCode() ?: 0)
        result = 31 * result + (prompt?.hashCode() ?: 0)
        result = 31 * result + (answers?.hashCode() ?: 0)
        result = 31 * result + (category?.hashCode() ?: 0)
        result = 31 * result + (picture?.hashCode() ?: 0)
        return result
    }


}
