package com.codingtest.albumlistapp.presentations

import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codingtest.albumlistapp.R

@BindingAdapter("imageUrl")
fun bindAlbumCover(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.baseline_broken_image_24))
            .into(imgView)
    }
}

@BindingAdapter("noOfCollection")
fun bindNoOfCollection(textView: TextView, noOfCollection: Int?) {
    noOfCollection?.let {
        textView.text = textView.context.getString(R.string.number_of_result_found_string_format, noOfCollection)
    }
}

@BindingAdapter("noOfSoundTrack")
fun bindNoOfSoundTrack(textView: TextView, noOfSoundTrack: Int?) {
    noOfSoundTrack?.let {
        textView.text = textView.context.getString(R.string.number_of_sound_track_string_format, noOfSoundTrack)
    }
}

@BindingAdapter("isBookmarked")
fun bindBookmarkIcon(imgButton: ImageButton, isBookmarked: Boolean?) {
    isBookmarked?.let {
        when(isBookmarked) {
            true -> imgButton.setImageResource(R.drawable.baseline_bookmark_24)
            else -> imgButton.setImageResource(R.drawable.baseline_bookmark_border_24)
        }
    }
}