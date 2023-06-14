package com.codingtest.albumlistapp.usecases.api

import com.codingtest.albumlistapp.utilities.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

private val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(Constants.BASE_URL)
    .build()

interface AlbumApiService {
    @GET
    fun searchAlbum(@Url url: String): Call<String>
}

object AlbumApi {
    val retrofitService: AlbumApiService by lazy {
        retrofit.create(AlbumApiService::class.java)
    }
}