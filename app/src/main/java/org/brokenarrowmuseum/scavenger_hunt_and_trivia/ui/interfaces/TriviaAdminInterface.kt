package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.interfaces

import android.view.View
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.Question


interface TriviaAdminInterface {
    fun onTriviaRecycerlViewItemClick(view: View, question : Question)
}