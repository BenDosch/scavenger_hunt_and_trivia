package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import java.lang.Exception
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.Question

/**
 * Class to create a connection to the database containing questions and to access and manipulate the data
 */

class QuestionsViewModel : ViewModel() {
    // Set up a connection to the Firebase database and get a reference to the questions document.
    private val qDatabase = FirebaseDatabase.getInstance().getReference("Questions")

    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>>
        get() = _questions

    private val _question = MutableLiveData<Question>()
    val question: LiveData<Question>
        get() = _question

    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?>
        get() = _result

    /**
     * Function that adds a question object to the database and reports the result
     * @question: <Question> question object to add to database
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

    fun updateQuestion(question: Question) {
        qDatabase.child(question.id!!).setValue(question)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    _result.value = null
                } else {
                    _result.value = it.exception
                }
            }
    }

    fun deleteQuestion(question: Question) {
        qDatabase.child(question.id!!).setValue(null)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    _result.value = null
                } else {
                    _result.value = it.exception
                }
            }
    }

    private val childEventListener = object : ChildEventListener {
        override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
            val question = snapshot.getValue(Question::class.java)
            question?.id = snapshot.key
            _question.value = question!!
        }
        override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
            val question = snapshot.getValue(Question::class.java)
            question?.id = snapshot.key
            _question.value = question!!
        }

        override fun onChildRemoved(snapshot: DataSnapshot) {
            val question = snapshot.getValue(Question::class.java)
            question?.id = snapshot.key
            question?.isDeleted = true
            _question.value = question!!
        }

        override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}

        override fun onCancelled(error: DatabaseError) {}
    }

    fun getRealtimeUpdate () {
        qDatabase.addChildEventListener(childEventListener)
    }

    fun fetchQuestions() {
        qDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val questions = mutableListOf<Question>()
                    for (questionSnapshot in snapshot.children) {
                        val question = questionSnapshot.getValue(Question::class.java)
                        question?.id = questionSnapshot.key
                        question?.let { questions.add(it) }
                    }
                    _questions.value = questions
                }
            }
            override fun onCancelled(error: DatabaseError) {}
        })
    }

    override fun onCleared() {
        super.onCleared()
        qDatabase.removeEventListener(childEventListener)
    }
}