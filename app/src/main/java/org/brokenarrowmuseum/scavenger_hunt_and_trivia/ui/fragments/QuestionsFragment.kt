package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.adapters.QuestionsAdapter
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.viewmodels.QuestionsViewModel


class QuestionsFragment : Fragment() {

    private lateinit var viewModel: QuestionsViewModel
    private val adapter = QuestionsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    fun onViewCreated(savedInstanceState: Bundle?) {
        /*super.onViewCreated(savedInstanceState)*/

        /*recycler_view_trivia.adapter = adapter*/

        viewModel.fetchQuestions()

        viewModel.questions.observe(viewLifecycleOwner, {
            adapter.setQuestions(it)
        })
    }
}

