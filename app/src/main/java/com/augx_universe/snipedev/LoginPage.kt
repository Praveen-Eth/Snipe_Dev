package com.augx_universe.snipedev

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.augx_universe.snipedev.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {
  lateinit  var binding: ActivityLoginPageBinding
  lateinit var authViewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login_page)
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.connector = authViewModel
        binding.lifecycleOwner = this


    }
}