package org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val btnEdit = findViewById<ImageButton>(R.id.btnAddQuestion)
        btnEdit.setOnClickListener {
            val intent = Intent(this, AddQuestionActivity::class.java)
            startActivity(intent)
        }

    }
}