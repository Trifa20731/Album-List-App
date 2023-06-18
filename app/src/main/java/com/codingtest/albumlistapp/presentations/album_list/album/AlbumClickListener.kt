package com.codingtest.albumlistapp.presentations.album_list.album

import com.codingtest.albumlistapp.entities.Album

class AlbumClickListener(val clickListener: (album: Album) -> Unit) {
    fun onClick(album: Album) {
        clickListener(album)
    }
}