package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments.AdminLoginFragment
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments.ScavengerHuntFragment
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments.TriviaFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val triviaFragment = TriviaFragment(filesDir.toString())
        val scavengerHuntFragment = ScavengerHuntFragment()
        val adminFragment = AdminLoginFragment()
        val fragmentContainerView = R.id.fcvMain

        supportFragmentManager.beginTransaction().apply {
            replace(fragmentContainerView, triviaFragment)
                .commit()
        }

        val btnTrivia = findViewById<Button>(R.id.btnTrivia)
        btnTrivia.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(fragmentContainerView, triviaFragment)
                addToBackStack(null)
                commit()
            }
        }

        val btnScavengerHunt = findViewById<Button>(R.id.btnScavengerHunt)
        btnScavengerHunt.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(fragmentContainerView, scavengerHuntFragment)
                addToBackStack(null)
                commit()
            }
        }

        val btnEdit = findViewById<Button>(R.id.btnEdit)
        btnEdit.setOnClickListener {
            supportFragmentManager.beginTransaction().apply{
                replace(fragmentContainerView, adminFragment)
                addToBackStack(null)
                commit()
            }
        }
    }


    /**
    fun saveFirebaseToFile() {
        val viewModel = QuestionsViewModel()
        viewModel.fetchTrivia()
        saveToFile(viewModel.questions as? MutableList<Question>)
    }
    */
}