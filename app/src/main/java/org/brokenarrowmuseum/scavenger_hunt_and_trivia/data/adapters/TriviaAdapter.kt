package org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.entities.Question


class TriviaAdapter(
    private val questions: MutableList<Question>
    ) : RecyclerView.Adapter<TriviaAdapter.TriviaViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class TriviaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvPrompt: TextView

        init {
            // Define click listener for the ViewHolder's View.
            tvPrompt = view.findViewById(R.id.tvPrompt)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TriviaViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycler_view_item, viewGroup, false)

        return TriviaViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: TriviaViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvPrompt.text = questions[position].prompt
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = questions.size

}