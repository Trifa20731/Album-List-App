package com.codingtest.albumlistapp.usecases.api

import com.codingtest.albumlistapp.entities.AlbumApiResponse
import com.codingtest.albumlistapp.utilities.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(Constants.BASE_URL)
    .build()

interface AlbumApiService {
    @GET
    suspend fun searchAlbum(@Url url: String): AlbumApiResponse
}

object AlbumApi {
    val retrofitService: AlbumApiService by lazy {
        retrofit.create(AlbumApiService::class.java)
    }
}