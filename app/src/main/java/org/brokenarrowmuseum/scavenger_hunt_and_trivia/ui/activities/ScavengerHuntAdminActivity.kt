package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.activities


import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments.AddTriviaDialogFragment
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments.AdminTriviaFragment

class ScavengerHuntAdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trivia_admin)
        val triviaFragment = AdminTriviaFragment()
        val fragmentContainerView = R.id.fcvAdmin

        supportFragmentManager.beginTransaction().apply {
            replace(fragmentContainerView, triviaFragment)
                .commit()
        }

        val addTrivia = this.findViewById<ImageButton>(R.id.imbtnAddQuestion)
        addTrivia.setOnClickListener {
            val dialog = AddTriviaDialogFragment()
            val fm = this.supportFragmentManager
            dialog.show(fm, "Add Triva")
        }
    }
}