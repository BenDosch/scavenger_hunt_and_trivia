package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.activities


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments.AddTriviaDialogFragment

class AddQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)
        val addTrivia = this.findViewById<Button>(R.id.btnTrivia)
        addTrivia.setOnClickListener {
            val dialog = AddTriviaDialogFragment()
            val fm = this.supportFragmentManager
            dialog.show(fm, "Add Triva")
        }
    }
}