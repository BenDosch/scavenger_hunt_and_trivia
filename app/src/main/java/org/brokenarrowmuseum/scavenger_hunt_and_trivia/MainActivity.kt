package org.brokenarrowmuseum.scavenger_hunt_and_trivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.entities.Question

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.CENTER
        recyclerView.layoutManager = layoutManager
        */

        val divLikeContent = ArrayList<String>()
        divLikeContent.add("Route")
        divLikeContent.add("No calls during the ride")
        divLikeContent.add("Smell")
        divLikeContent.add("Less talk")
        divLikeContent.add("Safety")

        val adapter = DivLikeAdapter(divLikeContent)

        // recyclerView.adapter = adapter

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
                addToBackStack(null)
                commit()
            }
        }

        val btnScavengerHunt = findViewById<Button>(R.id.btnScavengerHunt)
        btnTriva.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, scavengerHuntFragment)
                addToBackStack(null)
                commit()
            }
        }

        val btnEdit = findViewById<Button>(R.id.btnEdit)
        btnEdit.setOnClickListener {
            val intent = Intent(this, Admin::class.java)
            startActivity(intent)
        }

    }
    private fun generateRandonText(): String {
        val sb = StringBuilder()
        for (i in 1 + (Math.random() * 20).toInt() downTo 1) {
            sb.append("a")
        }
        return sb.toString()
    }
}