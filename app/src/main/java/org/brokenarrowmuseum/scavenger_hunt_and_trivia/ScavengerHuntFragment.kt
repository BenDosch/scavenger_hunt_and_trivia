package org.brokenarrowmuseum.scavenger_hunt_and_trivia

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.storage.QuestionsViewModel

class ScavengerHuntFragment : Fragment(R.layout.scavenger_hunt_fragment) {

    companion object {
        fun newInstance() = ScavengerHuntFragment()
    }

    private lateinit var viewModel: QuestionsViewModel



}