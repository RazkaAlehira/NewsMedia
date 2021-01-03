package com.example.newsmedia

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.newsmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val sharedPrefs = getSharedPreferences("production", Context.MODE_PRIVATE)
        val isSignedIn = sharedPrefs.getBoolean("is_signed_in", false)
        d("Clay", "Is User Signed In? $isSignedIn")

        if (!isSignedIn) {
            d("Clay", "Going To Login Screen...")
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            d("George", "Dream Love You...")
        }
    }
}