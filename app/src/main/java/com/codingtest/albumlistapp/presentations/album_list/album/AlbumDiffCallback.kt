package com.codingtest.albumlistapp.presentations.album_list.album

import androidx.recyclerview.widget.DiffUtil
import com.codingtest.albumlistapp.entities.Album

class AlbumDiffCallback: DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.collectionId == newItem.collectionId
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }
}