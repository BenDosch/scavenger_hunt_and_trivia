package org.brokenarrowmuseum.scavenger_hunt_and_trivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

private lateinit var linearLayoutManager: LinearLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

    }
}