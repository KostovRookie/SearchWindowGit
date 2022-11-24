package com.example.searchwindowgit.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.searchwindowgit.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private val TAG: String = "Inject test"

    @Inject

    lateinit var someRandomString: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Inject hilt test: $someRandomString")

        startActivity(intent)
        finish()
    }
}
