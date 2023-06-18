package com.codingtest.albumlistapp.presentations.album_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingtest.albumlistapp.entities.AlbumApiResponse
import com.codingtest.albumlistapp.usecases.api.AlbumApi
import com.codingtest.albumlistapp.usecases.api.AlbumApiStatus
import com.codingtest.albumlistapp.utilities.Constants
import kotlinx.coroutines.launch
import timber.log.Timber

class AlbumListViewModel: ViewModel() {

    companion object {
        private const val LOG_TAG: String = "AlbumListViewModel"
    }

    private val _albumApiResponse = MutableLiveData<AlbumApiResponse>()
    val albumApiResponse: LiveData<AlbumApiResponse>
        get() = _albumApiResponse

    private val _albumApiStatus = MutableLiveData<AlbumApiStatus>()
    val albumApiStatus: LiveData<AlbumApiStatus>
        get() = _albumApiStatus

    init {
        getAlbumSearchResult()
    }

    private fun getAlbumSearchResult() {
        viewModelScope.launch {
            _albumApiStatus.value = AlbumApiStatus.LOADING
            try {
                val tmpAlbumApiResponse = AlbumApi.retrofitService.searchAlbum(Constants.BASE_COMPLETE_URL)
                Timber.tag(LOG_TAG).i("Success: %d Mars properties retrieved", tmpAlbumApiResponse.resultCount)
                _albumApiResponse.value = tmpAlbumApiResponse
                _albumApiStatus.value = AlbumApiStatus.DONE
            } catch (e: Exception) {
                Timber.tag(LOG_TAG).e("Failure: %s", e.message)
                _albumApiStatus.value = AlbumApiStatus.ERROR
            }
        }
    }

}