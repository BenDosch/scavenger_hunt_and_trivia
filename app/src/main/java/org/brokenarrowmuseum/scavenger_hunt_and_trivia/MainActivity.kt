package org.brokenarrowmuseum.scavenger_hunt_and_trivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val triviaFragment = TriviaFragment()
        val scavengerHuntFragment = ScavengerHuntFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, triviaFragment)
                .commit()
        }

        val btnTriva = findViewById<Button>(R.id.btnTrivia)
        btnTriva.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, triviaFragment)
                addToBackStack()
                commit()
            }
        }

        val btnScavengerHunt = findViewById<Button>(R.id.btnScavengerHunt)
        btnTriva.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, scavengerHuntFragment)
                addToBackStack()
                commit()
            }
        }

        val btnEdit = findViewById<Button>(R.id.btnEdit)
        btnEdit.setOnClickListener {
            val intent = Intent(this, Admin::class.java)
            startActivity(intent)
        }
    }
}