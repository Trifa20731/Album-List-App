package com.codingtest.albumlistapp.presentations.album_list.album

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.codingtest.albumlistapp.entities.Album
import timber.log.Timber

class AlbumAdapter: ListAdapter<Album, AlbumViewHolder>(AlbumDiffCallback()) {

    companion object {
        private const val LOG_TAG: String = "AlbumAdapter"
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        Timber.tag(LOG_TAG).d("OnBindViewHolder: Run.")
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        Timber.tag(LOG_TAG).d("onCreateViewHolder: Run.")
        return AlbumViewHolder.from(parent)
    }

}