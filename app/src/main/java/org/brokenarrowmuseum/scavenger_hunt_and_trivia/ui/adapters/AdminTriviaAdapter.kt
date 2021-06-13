package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.Question
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.interfaces.RecyclerViewInterface

/**
 * Class for the adapter between the fragment and recycler view for the administrative trivia area.
 */

class AdminTriviaAdapter : RecyclerView.Adapter<AdminTriviaAdapter.QuestionViewModel>() {

    private var questions = mutableListOf<Question>()
    var listener: RecyclerViewInterface? = null

    fun setQuestions(questions: List<Question>) {
        this.questions = questions as MutableList<Question>
        notifyDataSetChanged()
    }

    fun addQuestion(question: Question) {
        if (!questions.contains(question)) {
            questions.add(question)
        } else {
            val index = questions.indexOf(question)
            if (question.isDeleted) {
                   questions.removeAt(index)
            } else {
                questions[index] = question
            }
        }
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): QuestionViewModel {
        // Create a new view, which defines the UI of the list item
        val view =LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.admin_trivia_item, viewGroup, false)
        return QuestionViewModel(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: QuestionViewModel, position: Int) {
        viewHolder.tvPrompt.text = questions[position].prompt
        viewHolder.imbtnEdit.setOnClickListener {
            listener?.onRecycerlViewItemClick(it, questions[position])
        }
        viewHolder.imbtnDelete.setOnClickListener {
            listener?.onRecycerlViewItemClick(it, questions[position])
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = questions.size

    inner class QuestionViewModel(view: View) : RecyclerView.ViewHolder(view) {
        val tvPrompt: TextView
        val imbtnEdit: ImageButton
        val imbtnDelete: ImageButton


        init {
            // Define click listener for the ViewHolder's View.
            tvPrompt = view.findViewById(R.id.tvPrompt)
            imbtnEdit = view.findViewById(R.id.imbtnEdit)
            imbtnDelete = view.findViewById(R.id.imbtnDelete)
        }
    }

}