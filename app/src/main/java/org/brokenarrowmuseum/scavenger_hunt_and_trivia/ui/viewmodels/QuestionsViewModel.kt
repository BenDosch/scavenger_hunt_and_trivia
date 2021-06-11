package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.*
import java.lang.Exception
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.Question

/**
 * Class to create a connection to the database at the "Questions" node, to access and manipulate the data
 */

class QuestionsViewModel : ViewModel() {
    // Set up a connection to the Firebase database and get a reference to the questions document.
    private val qDatabase = FirebaseDatabase.getInstance().getReference("Questions")

    // Set up values to access all questions in the "Questions" node
    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>>
        get() = _questions

    private val _question = MutableLiveData<Question>()
    val question: LiveData<Question>
        get() = _question

    // Set up values to access all trivia questions in the "Questions" node
    private val _tQuestions = MutableLiveData<List<Question>>()
    val tQuestions: LiveData<List<Question>>
        get() = _tQuestions

    private val _tQuestion = MutableLiveData<Question>()
    val tQuestion: LiveData<Question>
        get() = _tQuestion

    // Set up values to access all scavenger hunt questions in the "Questions" node
    private val _shQuestions = MutableLiveData<List<Question>>()
    val shQuestions: LiveData<List<Question>>
        get() = _shQuestions

    private val _shQuestion = MutableLiveData<Question>()
    val shQuestion: LiveData<Question>
        get() = _shQuestion

    // Set up value for reporting results of functions
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

    /**
     * Function that updates a question object in the database and reports the result
     * @question: <Question> question object to add to database
     */

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

    /**
     * Function that deletes a question object from the database and reports the result
     * @question: <Question> question object to add to database
     */

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

    /**
     * Set up a ChildEventListener to track changes and update the _question and _tQuestion values.
     */

    private val childEventListener = object : ChildEventListener {
        override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
            val question = snapshot.getValue(Question::class.java)
            question?.id = snapshot.key
            if (question?.format == "Triva") {
                _tQuestion.value = question!!
            }
            _question.value = question!!
        }
        override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
            val question = snapshot.getValue(Question::class.java)
            question?.id = snapshot.key
            if (question?.format == "Triva") {
                _tQuestion.value = question!!
            }
            _question.value = question!!
        }

        override fun onChildRemoved(snapshot: DataSnapshot) {
            val question = snapshot.getValue(Question::class.java)
            question?.id = snapshot.key
            question?.isDeleted = true
            if (question?.format == "Triva") {
                _tQuestion.value = question!!
            }
            _question.value = question!!
        }

        override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}

        override fun onCancelled(error: DatabaseError) {}
    }

    /**
     * Function that enables realtime updates for all questions database by applying a
     * ChildEventListener to the "Questions" node.
     */

    fun getRealtimeUpdate () {
        qDatabase.addChildEventListener(childEventListener)
    }

    /**
     * Function that sets the private list variable _questions to contain all children of the
     * "Questions" node of the database.
     */

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

    /**
     * Function that sets the private list variable _tQuestions to contain all children of the
     * "Questions" node of the database with the "format" of "Trivia".
     */

    fun fetchTrivia() {
        val tqDatabase = qDatabase.orderByChild("format").equalTo("Trivia")
        tqDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val questions = mutableListOf<Question>()
                    for (questionSnapshot in snapshot.children) {
                        val question = questionSnapshot.getValue(Question::class.java)
                        question?.id = questionSnapshot.key
                        question?.let { questions.add(it) }
                    }
                    _tQuestions.value = questions
                }
            }
            override fun onCancelled(error: DatabaseError) {}
        })
    }

    /**
     * Overrides the onCleared function to add the removal of EventListners added by functions
     * in the ViewModel
     */
    override fun onCleared() {
        super.onCleared()
        qDatabase.removeEventListener(childEventListener)
    }
}