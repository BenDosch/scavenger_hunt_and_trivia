package org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.ui.adapters.ScavengerHuntAdapter
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.Question

class ScavengerHuntFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scavenger_hunt, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val questionlist = mutableListOf<Question>(
            Question("1", isDeleted = false,"Scavenger Hunt", "Is this the real life?"),
            Question("2", isDeleted = false,"Scavenger Hunt", "Is this just fantasy?"),
            Question("3", isDeleted = false,"Scavenger Hunt", "Caught in a landslide"),
            Question("4", isDeleted = false,"Scavenger Hunt", "No escape from reality?"),
            Question("5", isDeleted = false,"Scavenger Hunt", "Open your eyes"),
            Question("6", isDeleted = false,"Scavenger Hunt", "Look up to the skies"),
            Question("7", isDeleted = false,"Scavenger Hunt", "and see!"),
            Question(
                "8", isDeleted = false,"Scavenger Hunt",
                "I'm just a poor boy, nobody loves me, because it's easy come, easy go. Little high, little low. Anyway the wind blows doesn't even mater to meeeee. Tooooo meeeeeeee."
            )
        )

        val adapter = ScavengerHuntAdapter(questionlist)
        val rvTriva = view?.findViewById<RecyclerView>(R.id.rvScavengerHunt)
        rvTriva?.adapter = adapter
        rvTriva?.layoutManager = LinearLayoutManager(activity)
    }
}