package com.codingtest.albumlistapp.utilities

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.codingtest.albumlistapp.entities.Album
import org.json.JSONObject



fun parseAlbumJsonResult(jsonResult: JSONObject): ArrayList<Album> {
    // Prepare to sequence the JSON Object.
    val albumList = ArrayList<Album>()
    val resultCountIntJson = jsonResult.getInt("resultCount")
    val resultsJsonArray = jsonResult.getJSONArray("results")

    for (i in 0 until resultsJsonArray.length()) {
        val albumJson: JSONObject = resultsJsonArray.getJSONObject(i)
        val collectionId: Long = albumJson.getLong("id")
        val artistName: String = albumJson.getString("artistName")
        val collectionName: String = albumJson.getString("collectionName")
        val album = Album(collectionId, artistName, collectionName)
        albumList.add(album)
    }
    return albumList
}

//fun getTodayDateString(): String {
//    val calendar = Calendar.getInstance()
//    val dateFormat = SimpleDateFormat(Constants.API_QUERY_DATE_FORMAT, Locale.getDefault())
//    val today = calendar.time
//    return dateFormat.format(today)
//}
//
//fun getDatePairString(): Pair<String,String> {
//    val calendar = Calendar.getInstance()
//    val dateFormat = SimpleDateFormat(Constants.API_QUERY_DATE_FORMAT, Locale.getDefault())
//    val startDate = calendar.time
//    calendar.add(Calendar.DAY_OF_YEAR, 7)
//    val endDate = calendar.time
//    return Pair(dateFormat.format(startDate), dateFormat.format(endDate))
//}

fun isNetworkAvailable(context: Context?): Boolean {
    if (context == null) return false
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    return true
                }
            }
        }
    } else {
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
            return true
        }
    }
    return false
}