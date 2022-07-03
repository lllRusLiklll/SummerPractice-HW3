package com.example.homework3

import androidx.recyclerview.widget.RecyclerView
import com.example.homework3.databinding.ItemGameBinding

class GameHolder(
    private val binding: ItemGameBinding,
    private val onItemClick: (Game) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(game: Game) {
        with (binding) {
            tvName.text = game.name
            tvDeveloper.text = game.developer
            ivCover.setImageResource(game.url)
            root.setOnClickListener {
                onItemClick(game)
            }
        }
    }
}