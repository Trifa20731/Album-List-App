package com.codingtest.albumlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.codingtest.albumlistapp.presentations.album_list.AlbumListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment = AlbumListFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.navHostFragment, fragment)
            .commit()
    }

}