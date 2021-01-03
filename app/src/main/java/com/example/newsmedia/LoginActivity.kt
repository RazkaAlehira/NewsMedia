package com.example.newsmedia

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import com.example.newsmedia.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSignin.setOnClickListener {
            if (edt_pass.text.toString() == "secret") {
                d("Clay", "Password Confirm!")
                val sharedPrefs = getSharedPreferences("production", Context.MODE_PRIVATE)
                with(sharedPrefs.edit()) {
                    putBoolean("is_signed_in", true)
                    commit()
                }
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                d("Clay", "Password Rejected!")
            }
        }
    }
}