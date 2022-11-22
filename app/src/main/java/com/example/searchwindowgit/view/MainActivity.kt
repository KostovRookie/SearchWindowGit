package com.example.searchwindowgit.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.searchwindowgit.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(intent)
        finish()
    }
}
