package com.example.homework3

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.homework3.databinding.FragmentInfoBinding

class InfoFragment : Fragment(R.layout.fragment_info) {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentInfoBinding.bind(view)

        with (binding) {
            val pref = activity?.getSharedPreferences("TEST", Context.MODE_PRIVATE) ?: return
            tvName.text = pref.getString("NAME", "error").orEmpty()
            ivCover.setImageResource(pref.getInt("URL", -1))
            tvDeveloper.text = pref.getString("DEVELOPER", "error").orEmpty()
            tvDescription.text = pref.getString("DESCRIPTION", "error").orEmpty()
        }
    }
}