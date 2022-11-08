package com.example.kotkindz1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotkindz1.Fragment.RecyclerFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerFragment = RecyclerFragment()

        val fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container,recyclerFragment)
            .commit()
    }
}