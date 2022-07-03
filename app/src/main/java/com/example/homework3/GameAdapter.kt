package com.example.homework3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework3.databinding.ItemGameBinding

class GameAdapter(
    private val list: List<Game>,
    private val onItemClick: (Game) -> Unit,
) : RecyclerView.Adapter<GameHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): GameHolder = GameHolder(
        ItemGameBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onItemClick,
    )

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}