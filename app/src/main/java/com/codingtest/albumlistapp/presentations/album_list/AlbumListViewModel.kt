package com.codingtest.albumlistapp.presentations.album_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingtest.albumlistapp.entities.AlbumApiResponse
import com.codingtest.albumlistapp.usecases.api.AlbumApi
import com.codingtest.albumlistapp.utilities.Constants
import kotlinx.coroutines.launch

class AlbumListViewModel: ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private val _albumApiResponse = MutableLiveData<AlbumApiResponse>()
    val albumApiResponse: LiveData<AlbumApiResponse>
        get() = _albumApiResponse

    init {
        getAlbumSearchResult()
    }

    private fun getAlbumSearchResult() {
        viewModelScope.launch {
            try {
                val tmpAlbumApiResponse = AlbumApi.retrofitService.searchAlbum(Constants.BASE_COMPLETE_URL)
                _albumApiResponse.value = tmpAlbumApiResponse
                _response.value = "Success: ${tmpAlbumApiResponse.resultCount} Mars properties retrieved"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }

}