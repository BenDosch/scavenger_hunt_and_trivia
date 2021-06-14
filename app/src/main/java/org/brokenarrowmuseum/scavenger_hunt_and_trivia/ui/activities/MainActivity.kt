package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.serialization.json.Json
import kotlinx.serialization.stringify
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.Question
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments.AdminLoginFragment
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments.ScavengerHuntFragment
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments.TriviaFragment
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val triviaFragment = TriviaFragment()
        val scavengerHuntFragment = ScavengerHuntFragment()
        val adminFragment = AdminLoginFragment()
        val fragmentContainerView = R.id.fcvMain
        val FILE_NAME = "triva.txt"
        val testQuestion = Question("42", false, "arfegi")
        val testQuestion2 = Question("24", false, "[]'=']")


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

        fun saveToFile() {
            val storageText = Json.encodeToString(Question.serializer(), testQuestion)
            val storageText2 = Json.encodeToString(Question.serializer(), testQuestion2)
            val file = File(filesDir.toString() + "/" + FILE_NAME)

            file.writeText(storageText)
            if (file.exists()) {
                Toast.makeText(this, "Saved to" + filesDir + "/" + FILE_NAME, Toast.LENGTH_LONG).show()
            }
        }

        fun loadFromFile() {
            val file = File(filesDir.toString() + "/" + FILE_NAME)
            val fileText = file.readText()
            val obj : Question = Json.decodeFromString(Question.serializer(), fileText)

            findViewById<TextView>(R.id.textView2).text = obj.response
        }

        saveToFile()
        loadFromFile()

    }
}