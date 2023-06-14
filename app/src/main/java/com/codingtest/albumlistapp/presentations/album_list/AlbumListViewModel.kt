package com.codingtest.albumlistapp.presentations.album_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codingtest.albumlistapp.usecases.api.AlbumApi
import com.codingtest.albumlistapp.utilities.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumListViewModel: ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getAlbumSearchResult()
    }

    private fun getAlbumSearchResult() {
        AlbumApi.retrofitService.searchAlbum(Constants.BASE_COMPLETE_URL).enqueue( object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }
        })
    }

}