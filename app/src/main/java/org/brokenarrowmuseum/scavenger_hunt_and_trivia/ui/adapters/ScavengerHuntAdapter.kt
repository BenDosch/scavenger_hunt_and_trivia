package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.Question


class ScavengerHuntAdapter(
    private val questions: MutableList<Question>
    ) : RecyclerView.Adapter<ScavengerHuntAdapter.ScavengerHuntViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ScavengerHuntViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDescription: TextView

        init {
            // Define click listener for the ViewHolder's View.
            tvDescription = view.findViewById(R.id.tvDescription)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ScavengerHuntViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.scavenger_hunt_item, viewGroup, false)

        return ScavengerHuntViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ScavengerHuntViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvDescription.text = questions[position].prompt
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = questions.size

}