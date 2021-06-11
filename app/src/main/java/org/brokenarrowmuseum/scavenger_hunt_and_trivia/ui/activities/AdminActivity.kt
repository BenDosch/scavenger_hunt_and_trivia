package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val triviaAdmin = findViewById<Button>(R.id.btnTriviaAdmin)
        triviaAdmin.setOnClickListener {
            val intent = Intent(this, TriviaAdminActivity::class.java)
            startActivity(intent)
        }

        /**
        val scavengerHuntAdmin = findViewById<Button>(R.id.btnScavengerHuntAdmin)
        scavengerHuntAdmin.setOnClickListener {
            val intent = Intent(this, ScavengerHuntAdminActivity::class.java)
            startActivity(intent)
        }
        */
    }
}