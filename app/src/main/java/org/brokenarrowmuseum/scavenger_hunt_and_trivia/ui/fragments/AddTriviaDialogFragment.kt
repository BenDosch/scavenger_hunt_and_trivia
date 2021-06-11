package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.Question
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.viewmodels.QuestionsViewModel


class AddTriviaDialogFragment : DialogFragment() {

    private lateinit var viewModel: QuestionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Set up the ViewModel
        viewModel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_trivia_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.result.observe(viewLifecycleOwner, {
            val message = if (it == null) {
                getString(R.string.Author_Addedd)
            } else {
                getString(R.string.Error, it.message)
            }
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            dismiss()
        })

        val addTrivia = view.findViewById<Button>(R.id.btnAddTriviaQuestion)
        addTrivia.setOnClickListener {
            val prompt = view.findViewById<EditText>(R.id.etPrompt).text.toString()
            val category = view.findViewById<EditText>(R.id.etCategory).text.toString()
            if (prompt.isEmpty() or  category.isEmpty()) {
                return@setOnClickListener
            }
            val question = Question(prompt = prompt, format = "Trivia", category = category)
            viewModel.addQuestion(question)
        }
    }


}