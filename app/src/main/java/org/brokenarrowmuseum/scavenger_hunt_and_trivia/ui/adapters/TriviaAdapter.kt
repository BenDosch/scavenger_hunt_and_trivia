package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.Question


class TriviaAdapter() : RecyclerView.Adapter<TriviaAdapter.QuestionViewModel>() {

    private var questions = mutableListOf<Question>()

    fun setQuestions(questions: List<Question>) {
        this.questions = questions as MutableList<Question>
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): QuestionViewModel {
        // Create a new view, which defines the UI of the list item
        val view =LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.trivia_item, viewGroup, false)
        return QuestionViewModel(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: QuestionViewModel, position: Int) {
        viewHolder.tvPrompt.text = questions[position].prompt
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = questions.size

    class QuestionViewModel(view: View) : RecyclerView.ViewHolder(view) {
        val tvPrompt: TextView

        init {
            // Define click listener for the ViewHolder's View.
            tvPrompt = view.findViewById(R.id.tvPrompt)
        }
    }

}