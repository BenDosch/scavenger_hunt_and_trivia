package org.brokenarrowmuseum.scavenger_hunt_and_trivia

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.storage.QuestionsViewModel

class TriviaFragment : Fragment(R.layout.trivia_fragment) {

    private lateinit var viewModel: QuestionsViewModel
    private val adapter = QuestionsAdapter()

    fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        recycler_view_questions.adapter = adapter

        viewModel.fetchQuestions()

        viewModel.authors.observe(viewLifecycleOwner, {
            adapter.setQuestions(it)
        })
    }
}