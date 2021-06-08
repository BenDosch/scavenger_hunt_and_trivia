package org.brokenarrowmuseum.scavenger_hunt_and_trivia.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.brokenarrowmuseum.scavenger_hunt_and_trivia.R

class DivLikeAdapter(private val mItems: ArrayList<String>) : RecyclerView.Adapter<DivLikeAdapter.DivItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DivItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return DivItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: DivItemViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class DivItemViewHolder constructor(itemView: View) : RecyclerView.ViewHolder
        (itemView) {
        private val text: TextView = itemView.findViewById(R.id.text)

        fun onBind(position: Int) {
            text.text = mItems[position]
        }
    }
}