package com.codingtest.albumlistapp.presentations.bookmarked_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingtest.albumlistapp.R
import com.codingtest.albumlistapp.databinding.FragmentAlbumListBinding
import com.codingtest.albumlistapp.databinding.FragmentBookmarkedListBinding


class BookmarkedListFragment : Fragment() {

    private var bookmarkedListString: String = ""

    companion object {
        fun newInstance(data: String): BookmarkedListFragment {
            val fragment = BookmarkedListFragment()
            val args = Bundle()
            args.putString("BOOKMARK_LIST_STRING", data)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString("BOOKMARK_LIST_STRING")?.let {
            bookmarkedListString = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBookmarkedListBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.bookmarkedListTv.text = bookmarkedListString

        return binding.root

    }

}