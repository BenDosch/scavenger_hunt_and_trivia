package org.brokenarrowmuseum.scavenger_hunt_and_trivia.data

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.AddQuestion
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.QuestionsAdapter
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.entities.Question
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.storage.QuestionsViewModel


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

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        recycler_view_questions.adapter = adapter

        viewModel.fetchQuestions()

        viewModel.authors.observe(viewLifecycleOwner, Observer {
            adapter.setQuestions(it)
        })
    }
}