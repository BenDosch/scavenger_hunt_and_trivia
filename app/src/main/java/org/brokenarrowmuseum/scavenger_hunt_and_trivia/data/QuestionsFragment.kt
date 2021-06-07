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
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.entities.Question
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.storage.QuestionsViewModel


class AuthorsFragment : Fragment(), RecyclerViewClickListener {

    private lateinit var viewModel: QuestionsViewModel
    private val adapter = QuestionsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_authors, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter.listener = this
        recycler_view_questions.adapter = adapter

        viewModel.fetchFilteredAuthors(6)
//        viewModel.getRealtimeUpdates()

        viewModel.authors.observe(viewLifecycleOwner, Observer {
            adapter.setAuthors(it)
        })

        viewModel.author.observe(viewLifecycleOwner, Observer {
            adapter.addAuthor(it)
        })

        button_add.setOnClickListener {
            AddQuestionDialogFragment()
                .show(childFragmentManager, "")
        }
    }

    override fun onRecyclerViewItemClicked(view: View, question: Question) {
        when (view.id) {
            R.id.button_edit -> {
                EditQuestionDialogFragment(question).show(childFragmentManager, "")
            }
            R.id.button_delete -> {
                AlertDialog.Builder(requireContext()).also {
                    it.setTitle(getString(R.string.delete_confirmation))
                    it.setPositiveButton(getString(R.string.yes)) { dialog, which ->
                        question.id?.let { it1 -> viewModel.deleteQuestion(it1) }
                    }
                }.create().show()
            }
        }
    }
}