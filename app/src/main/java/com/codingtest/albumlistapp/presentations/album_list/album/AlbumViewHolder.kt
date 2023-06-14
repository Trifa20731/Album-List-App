package com.codingtest.albumlistapp.presentations.album_list.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingtest.albumlistapp.databinding.ListItemAlbumBinding
import com.codingtest.albumlistapp.entities.Album

class AlbumViewHolder private constructor(private val binding: ListItemAlbumBinding): RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): AlbumViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemAlbumBinding.inflate(layoutInflater, parent, false)
            return AlbumViewHolder(binding)
        }
    }

    fun bind(item: Album) {
        binding.album = item
        binding.executePendingBindings()
    }
}