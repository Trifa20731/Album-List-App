package com.codingtest.albumlistapp.presentations.album_list.album

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.codingtest.albumlistapp.entities.Album

class AlbumAdapter: ListAdapter<Album, AlbumViewHolder>(AlbumDiffCallback()) {

    companion object {
        private const val LOG_TAG: String = "AlbumAdapter"
    }

    /**
     * Aim to render UI according to the given style.
     * */
    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        Log.d(LOG_TAG, "OnBindViewHolder: Run.")
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        Log.d(LOG_TAG, "onCreateViewHolder: Run.")
        return AlbumViewHolder.from(parent)
    }

}