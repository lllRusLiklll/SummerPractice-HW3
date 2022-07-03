package com.example.homework3

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework3.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private var adapter: GameAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        adapter = GameAdapter(GameRepository.games) {
            val pref = activity?.getSharedPreferences("TEST", Context.MODE_PRIVATE)
            pref?.edit {
                putString("NAME", it.name)
                putString("DEVELOPER", it.developer)
                putInt("URL", it.url)
                putString("DESCRIPTION", it.description)
                commit()
            }
            findNavController().navigate(
                R.id.action_mainFragment_to_infoFragment
            )
        }
        binding.rvGames.adapter = adapter

        val pref = activity?.getSharedPreferences("TEST", Context.MODE_PRIVATE) ?: return
        val value = pref.all
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}