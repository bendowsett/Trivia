package com.example.trivia

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.trivia.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val argBundle = Bundle()
        argBundle.putString("Hey", "Hello")

        val fragment = GameFragment()
        fragment.arguments = argBundle
        var binding : FragmentTitleBinding = FragmentTitleBinding.inflate(inflater, container, false)
        binding.playButton.setOnClickListener {
            findNavController().navigate(R.id.action_titleFragment_to_gameFragment, argBundle)
        }

        setHasOptionsMenu(true)



        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }






}