package org.brokenarrowmuseum.scavenger_hunt_and_trivia

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.entities.Question

class questionsAdapter : RecyclerView.Adapter<questionsAdapter.questionViewModel>() {

    private var questions = mutableListOf<Question>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = questionViewModel(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
    )

    override fun getItemCount() = questions.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: questionViewModel, position: Int) {
        holder.view.text_view_name.text = questions[position].name
        holder.view.text_view_city_votes.text =
            "${questions[position].city} | Votes : ${questions[position].votes}"
        holder.view.button_edit.setOnClickListener {
            listener?.onRecyclerViewItemClicked(it, questions[position])
        }
        holder.view.button_delete.setOnClickListener {
            listener?.onRecyclerViewItemClicked(it, questions[position])
        }
    }

    fun setquestions(questions: List<question>) {
        this.questions = questions as MutableList<question>
        notifyDataSetChanged()
    }

    fun addquestion(question: question) {
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

    class questionViewModel(val view: View) : RecyclerView.ViewHolder(view)
}