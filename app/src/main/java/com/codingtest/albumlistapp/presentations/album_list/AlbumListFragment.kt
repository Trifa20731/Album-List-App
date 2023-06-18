package com.codingtest.albumlistapp.presentations.album_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.codingtest.albumlistapp.R
import com.codingtest.albumlistapp.databinding.FragmentAlbumListBinding
import com.codingtest.albumlistapp.presentations.album_list.album.AlbumAdapter
import com.codingtest.albumlistapp.presentations.album_list.album.AlbumClickListener
import com.codingtest.albumlistapp.presentations.bookmarked_list.BookmarkedListFragment


class AlbumListFragment : Fragment() {

    private val viewModel: AlbumListViewModel by lazy {
        ViewModelProvider(this)[AlbumListViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAlbumListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = AlbumAdapter(AlbumClickListener { album ->
            val currentAlbumBookmarkedState: Boolean = album.isBookmarked
            album.isBookmarked = !currentAlbumBookmarkedState
            if(album.isBookmarked) {
                viewModel.bookmarkedList.add(album.collectionName)
                Toast.makeText(requireContext(), "Add to bookmark: ${album.collectionName}", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.bookmarkedList.remove(album.collectionName)
                Toast.makeText(requireContext(), "Remove from bookmark: ${album.collectionName}", Toast.LENGTH_SHORT).show()
            }
        })
        binding.resultList.adapter = adapter

        binding.bookmarkFloatingActionButton.setOnClickListener{
            val bookmarkedListFragment = BookmarkedListFragment.newInstance(viewModel.getBookmarkedListString())
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.navHostFragment, bookmarkedListFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        viewModel.albumApiResponse.observe(viewLifecycleOwner) {
            adapter.submitList(it.results)
        }

        return binding.root
    }

}