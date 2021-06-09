package org.brokenarrowmuseum.scavenger_hunt_and_trivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.fragments.ScavengerHuntFragment
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.fragments.TriviaFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val triviaFragment = TriviaFragment()
        val scavengerHuntFragment = ScavengerHuntFragment()
        val adminFragment = admin_login()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, triviaFragment)
                .commit()
        }

        val btnTriva = findViewById<Button>(R.id.btnTrivia)
        btnTriva.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, triviaFragment)
                addToBackStack(null)
                commit()
            }
        }

        val btnScavengerHunt = findViewById<Button>(R.id.btnScavengerHunt)
        btnScavengerHunt.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, scavengerHuntFragment)
                addToBackStack(null)
                commit()
            }
        }

        val btnEdit = findViewById<Button>(R.id.btnEdit)
        btnEdit.setOnClickListener {
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragmentContainerView, adminFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}