package com.codingtest.albumlistapp.presentations.album_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.codingtest.albumlistapp.R
import com.codingtest.albumlistapp.databinding.FragmentAlbumListBinding
import com.codingtest.albumlistapp.presentations.album_list.album.AlbumAdapter


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

        val adapter = AlbumAdapter()
        binding.resultList.adapter = adapter

        viewModel.albumApiResponse.observe(viewLifecycleOwner) {
            adapter.submitList(it.results)
        }
        return binding.root
    }

}