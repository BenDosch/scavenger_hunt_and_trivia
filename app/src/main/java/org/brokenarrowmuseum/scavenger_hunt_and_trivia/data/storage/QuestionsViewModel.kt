package org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.storage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.Exception
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.entities.Question

/**
 * Class to create a connection to the database containing questions and to access and manipulate the data
 */

class
QuestionsViewModel : ViewModel() {
    // Set up a connection to the Firebase database and get a reference to the questions document.
    private val qDatabase = FirebaseDatabase.getInstance().getReference("Questions")

    private val _questions = MutableLiveData<List<Question>>()
    val authors: LiveData<List<Question>>
        get() = _questions

    private val _question = MutableLiveData<Question>()
    val author: LiveData<Question>
        get() = _question

    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?>
        get() = _result

    /**
     * Function that adds a question object to the database
     * @question: <Question> question object to add to database
     * Return: 1 on success, 0 on failure.
     */

    fun addQuestion(question: Question) {
        question.id = qDatabase.push().key
        qDatabase.child(question.id!!).setValue(question)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    _result.value = null
                } else {
                    _result.value = it.exception
                }
            }
    }

    /**
     * Function that deletes a question object from the database
     * @id: <String> id of the question to delete.
     * Return: 1 on success, 0 on failure.
     */

    fun deleteQuestion(id: String): Int {
        try {
            qDatabase.child("Questions").child(id).setValue(null)
        } catch (e: Exception) {
            return 0
        }
        return 1
    }


    fun fetchQuestions() {
        qDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val questions = mutableListOf<Question>()
                if (snapshot.exists()) {
                    for (child in snapshot.children) {
                        val question = child.getValue(Question::class.java)
                        question?.id = child.key
                        if (question != null) {
                            questions.add(element = question)
                        }
                    }
                    _questions.value = questions
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}

    /**
     * Maybe we want to do this logic internally instead of a call to the database? Will have to look up if this is a database call each time.
     * Function that returns a list of questions with the passed category value from the database
     * @category: <String> name of category to get questions from.
     * Return: List of Question objects from the database on success, empty list on failure.
     */


/** Saved for later use
var question = Question(id = id)
try {
    val questionListner =  object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            question.format = dataSnapshot.child("format").value.toString()
            question.category = dataSnapshot.child("category").value.toString()
            question.prompt = dataSnapshot.child("prompt").value.toString()
            val answers = mutableListOf<String>()
            for (each in dataSnapshot.child("answers").children) {
                answers.add(each.toString())
            }
            question.picture = dataSnapshot.child("picture").value.toString()
        }

        override fun onCancelled(databaseError: DatabaseError) {
        }
    }
    ref.child(id).addValueEventListener(questionListner)

} catch (e: Exception) {
    return null
}
return question
        */
