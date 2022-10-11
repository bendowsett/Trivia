package com.example.trivia

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.navArgument
import com.example.trivia.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {

    lateinit var binding: FragmentGameWonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameWonBinding.inflate(inflater, container, false)
        binding.nextMatchButton.setOnClickListener {
            findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    fun getShareIntent(): Intent {
        var args = GameWonFragmentArgs.fromBundle(requireArguments())
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(
            Intent.EXTRA_TEXT,
            getString(R.string.share_success_text, args.numCorrect, args.numQuestions)
        )
        return shareIntent

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
        // check if the activity resolves

        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }



        private fun shareSuccess() {
            startActivity(getShareIntent())
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.share -> shareSuccess()
            }

            return super.onOptionsItemSelected(item)
        }

}