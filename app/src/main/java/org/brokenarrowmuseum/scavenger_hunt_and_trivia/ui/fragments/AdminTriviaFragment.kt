package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments

import android.app.AlertDialog
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
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.interfaces.TriviaAdminInterface
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.adapters.AdminTriviaAdapter
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.viewmodels.QuestionsViewModel

/**
 * Fragment class that is set up to hold the recycler view for the trivia administrative activity
 */

class AdminTriviaFragment : Fragment() , TriviaAdminInterface {

    private lateinit var viewModel : QuestionsViewModel
    private val adapter = AdminTriviaAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initilaize the viewModel using the fragments view
        viewModel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trivia, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        adapter.listner = this

        viewModel.fetchTrivia()
        viewModel.getRealtimeUpdate()

        viewModel.tQuestions.observe(viewLifecycleOwner, {
            adapter.setQuestions(it)
        })
        viewModel.tQuestion.observe(viewLifecycleOwner, Observer {
            adapter.addQuestion(it)
        })

        val rvTriva = view?.findViewById<RecyclerView>(R.id.rvTrivia)
        rvTriva?.adapter = adapter
        rvTriva?.layoutManager = LinearLayoutManager(activity)
    }

    override fun onTriviaRecycerlViewItemClick(view: View, question: Question) {
        when (view.id) {
            R.id.imbtnEdit -> {
                EditTriviaDialogFragment(question).show(childFragmentManager, "")
            }
            R.id.imbtnDelete -> {
                AlertDialog.Builder(requireContext()).also {
                    it.setTitle(getString(R.string.Delete_Confirmation))
                    it.setPositiveButton(getString(R.string.Yes)) {
                        dialog, which -> viewModel.deleteQuestion(question)
                    }
                }.create().show()

            }
        }
    }
}