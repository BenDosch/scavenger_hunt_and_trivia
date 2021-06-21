package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.Question
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.adapters.TriviaAdapter
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.interfaces.RecyclerViewInterface
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.viewmodels.QuestionsViewModel

/**
 * Fragment that holds the recycler view of all the trivia questions to users.
 */

class TriviaFragment : Fragment(), RecyclerViewInterface {

    private lateinit var viewModel : QuestionsViewModel
    private val adapter = TriviaAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize the viewModel using the fragments view
        viewModel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trivia, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        adapter.listener = this

        viewModel.fetchTrivia()
        viewModel.getRealtimeUpdate()

        viewModel.tQuestions.observe(viewLifecycleOwner, Observer {
            adapter.setQuestions(it)
        })
        viewModel.tQuestion.observe(viewLifecycleOwner, Observer {
            adapter.addQuestion(it)
        })

        val rvTrivia = view?.findViewById<RecyclerView>(R.id.rvTrivia)
        rvTrivia?.adapter = adapter
        rvTrivia?.layoutManager = LinearLayoutManager(activity)
    }

    override fun onRecycerlViewItemClick(view: View, question: Question) {
        when (view.id) {
            R.id.btnAnswerTriviaQuestion -> {
                AnswerTriviaDialogFragment(question).show(childFragmentManager, "")
            }
        }
    }
}