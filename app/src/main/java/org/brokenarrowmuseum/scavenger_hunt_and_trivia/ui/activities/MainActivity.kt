package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments.ScavengerHuntFragment
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments.TriviaFragment
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments.AdminLoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val triviaFragment = TriviaFragment()
        val scavengerHuntFragment = ScavengerHuntFragment()
        val adminFragment = AdminLoginFragment()
        val fragmentContainerView = R.id.fcvMain

        supportFragmentManager.beginTransaction().apply {
            replace(fragmentContainerView, triviaFragment)
                .commit()
        }

        val btnTriva = findViewById<Button>(R.id.btnTrivia)
        btnTriva.setOnClickListener {
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
}