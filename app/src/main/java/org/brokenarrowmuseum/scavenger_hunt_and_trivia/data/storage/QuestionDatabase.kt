package org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.storage

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import android.util.Log
import java.lang.Exception
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.entities.Question

/**
 * Class to create a connection to the database containing questions and to access and manipulate the data
 */

class QuestionDatabase {
    // Set up a connection to the Firebase database and get a reference to the questions document.
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val myRef = database.getReference("Questions")

    /**
     * Part of the learning process, not meant for final application
     */
    companion object {
        private const val TAG = "KotlinActivity"
    }

    /**
     * Part of the learning process, not meant for final application
     */
    fun basicReadWrite() {
        // [START write_message]
        // Write a message to the database
        myRef.setValue("Hello, World!")
        // [END write_message]

        // [START read_message]
        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue()
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        // [END read_message]
    }

    /**
     * Function that json serialises and adds a question object to the database
     * @question: <Question> question object to add to database
     * Return: 1 on success, 0 on failure.
     */

    fun addQuestion(question: Question): Int {
        return 0
    }

    /**
     * Function that deletes a question object from the database
     * @id: <String> id of the question to delete.
     * Return: 1 on success, 0 on failure.
     */

    fun deleteQuestion(id: String): Int {
        return 0
    }

    /**
     * Function that returns a singe question from the database based on id
     * @id: <String> id of the question you wish to get.
     * Return: Question object on success, null on failure.
     */

    fun getQuestion(id: String): Question? {
        val question = Question()
        try {

        } catch (e: Exception) {
            return null
        }
        return question
    }

    /**
     * Function that returns a list of all questions from the database
     * Return: List of Question objects from the database on success, empty list on failure.
     */

    fun getAll() : List<Question> {
        val qList = listOf<Question>()
        return try {
            emptyList()
        } catch (e: Exception) {
            emptyList()
        }
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