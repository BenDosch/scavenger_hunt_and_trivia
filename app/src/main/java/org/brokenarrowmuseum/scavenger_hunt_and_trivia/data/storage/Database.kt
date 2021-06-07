package org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.storage

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.Exception
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.entities.Question

/**
 * Class to create a connection to the database containing questions and to access and manipulate the data
 */

class Database {
    // Set up a connection to the Firebase database and get a reference to the questions document.
    private val database = FirebaseDatabase.getInstance()
    private val ref = database.getReference()

    // generate a list of all questions in the database and put listners on that list, then return the list with get all.
    var allQuestions = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            val value = dataSnapshot.getValue()
        }

        override fun onCancelled(error: DatabaseError) {}
    }


    /**
     * Function that adds a question object to the database
     * @question: <Question> question object to add to database
     * Return: 1 on success, 0 on failure.
     */

    fun addQuestion(question: Question): Int {
        try {
            ref.child("Questions").child(question.id.toString()).setValue(question)
        } catch (e: Exception) {
            return 0
        }
        return 1
    }

    /**
     * Function that deletes a question object from the database
     * @id: <String> id of the question to delete.
     * Return: 1 on success, 0 on failure.
     */

    fun deleteQuestion(id: String): Int {
        try {
            ref.child("Questions").child(id).setValue(null)
        } catch (e: Exception) {
            return 0
        }
        return 1
    }

    /**
     * Function that returns a singe question from the database based on id
     * @id: <String> id of the question you wish to get.
     * Return: Question object on success, null on failure.
     */

    fun getQuestion(id: String): Question? {
        if (id == 0) { return null}
        return Question()
    }

    /**
     * Function that returns a list of all questions from the database
     * Return: List of Question objects from the database on success, empty list on failure.
     */

    fun getAll() : List<Question> {
        return emptyList()
    }

    /**
     * Maybe we want to do this logic internally instead of a call to the database? Will have to look up if this is a database call each time.
     * Function that returns a list of questions with the passed category value from the database
     * @category: <String> name of category to get questions from.
     * Return: List of Question objects from the database on success, empty list on failure.
     */

    fun getCategory(category: String) : List<Question> {
        val qList = listOf<Question>()
        return try {
            emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }
}


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
