package com.codingtest.albumlistapp.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Album(
    val collectionId: Long,
    val artistName: String,
    val collectionName: String
): Parcelable
