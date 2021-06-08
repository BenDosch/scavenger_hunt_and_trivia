package org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.fragments

import androidx.fragment.app.Fragment
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.storage.QuestionsViewModel

class ScavengerHuntFragment : Fragment(R.layout.scavenger_hunt_fragment) {

    companion object {
        fun newInstance() = ScavengerHuntFragment()
    }

    private lateinit var viewModel: QuestionsViewModel



}