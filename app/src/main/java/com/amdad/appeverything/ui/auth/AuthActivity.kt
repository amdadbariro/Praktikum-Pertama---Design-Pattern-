package com.amdad.appeverything.ui.auth

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.amdad.appeverything.R
import com.amdad.appeverything.data.model.AuthUser
import com.amdad.appeverything.databinding.ActivityAuthBinding
import com.amdad.appeverything.ui.home.MainActivity

class AuthActivity : AppCompatActivity() {
    lateinit var binding : ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
    }

    fun onSucces(user: AuthUser?){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}