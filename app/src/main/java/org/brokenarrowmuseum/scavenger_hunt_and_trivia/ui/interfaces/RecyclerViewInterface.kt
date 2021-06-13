package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.interfaces

import android.view.View
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.Question

/**
 * Interface to handle button clicks for individual items in the Trivia Administrative Recycler View.
 */

interface RecyclerViewInterface {
    fun onRecycerlViewItemClick(view: View, question : Question)
}