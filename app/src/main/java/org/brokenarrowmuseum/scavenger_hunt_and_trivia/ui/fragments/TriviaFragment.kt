package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.serialization.json.Json
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.Question
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.adapters.TriviaAdapter
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.interfaces.RecyclerViewInterface
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.viewmodels.QuestionsViewModel
import java.io.File

/**
 * Fragment that holds the recycler view of all the trivia questions to users.
 */

class TriviaFragment(
    val FILE_DIRECTORY: String
) : Fragment(), RecyclerViewInterface {

    private lateinit var viewModel : QuestionsViewModel
    private var questionsList = loadFromFile()
    private val adapter = TriviaAdapter(questionsList)
    private val FILE_NAME = "triva.txt"

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

    fun saveToFile(questionList: MutableList<Question>) {
        var finalString: String = ""
        for (question in questionList) {
            if (finalString == "") {
                finalString = Json.encodeToString(Question.serializer(), question)
            } else {
                finalString = finalString + "\n" + question
            }
        }
        val file = File(FILE_DIRECTORY + "/" + FILE_NAME)

        file.writeText(finalString)
    }

    fun loadFromFile(): MutableList<Question> {
        val file = File(FILE_DIRECTORY + "/" + FILE_NAME)
        val fileList = file.readLines()
        var questionList = mutableListOf<Question>()
        for (obj in fileList) {
            questionList.add(Json.decodeFromString(Question.serializer(), obj))
        }
        return questionList
    }
}