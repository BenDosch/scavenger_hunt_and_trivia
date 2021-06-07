package org.brokenarrowmuseum.scavenger_hunt_and_trivia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.entities.Question

class QuestionsAdapter : RecyclerView.Adapter<QuestionsAdapter.QuestionViewModel>() {

    private var questions = mutableListOf<Question>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = QuestionViewModel(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
    )

    override fun getItemCount() = questions.size

    override fun onBindViewHolder(holder: QuestionViewModel, position: Int) {
        holder.view.textView1.text = questions[position].prompt
    }

    fun setQuestions(questions: List<Question>) {
        this.questions = questions as MutableList<Question>
        notifyDataSetChanged()
    }

    fun addQuestion(question: Question) {
        if (!questions.contains(question)) {
            questions.add(question)
        } else {
            val index = questions.indexOf(question)
        }
        notifyDataSetChanged()
    }

    class QuestionViewModel(val view: View) : RecyclerView.ViewHolder(view)

}