package com.augx_universe.snipedev

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.room.Entity
import com.augx_universe.snipedev.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity(),ActivityStarter {
  lateinit  var binding: ActivityLoginPageBinding
  lateinit var authViewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login_page)
        authViewModel =  ViewModelProvider(this)
            .get(AuthViewModel::class.java)
        binding.connector = authViewModel
        binding.lifecycleOwner = this
        authViewModel.setActivityStarter(this)







    }

    //callback function link@ AuthViewModel
    override fun startSignupActivity() {
        val intent: Intent  =  Intent(this,SignUpActivity::class.java)
        startActivity(intent)

    }
}