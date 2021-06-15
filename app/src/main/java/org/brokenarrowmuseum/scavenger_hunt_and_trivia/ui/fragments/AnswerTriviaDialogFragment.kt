package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.Question
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.viewmodels.QuestionsViewModel

/**
 * Class that sets up the dialog fragment for editing trivia questions in the administrative area.
 */

class AnswerTriviaDialogFragment (
    private val question : Question
        ) : DialogFragment() {

    private lateinit var viewModel: QuestionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Set up the ViewModel
        viewModel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_answer_trivia_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.tvTriviaPrompt).setText(question.prompt)
        view.findViewById<EditText>(R.id.etResponse).setText(question.response)

        viewModel.result.observe(viewLifecycleOwner, {
            val message = if (it == null) {
                getString(R.string.Question_Answered)
            } else {
                getString(R.string.Error, it.message)
            }
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            dismiss()
        })


        view.findViewById<Button>(R.id.btnAnswerTriviaQuestion).setOnClickListener {
            val response = view.findViewById<TextView>(R.id.etResponse).text.toString()
            if (response.isEmpty()) {
                return@setOnClickListener
            }
            question.response = response
            viewModel.updateQuestion(question)
        }
    }
}