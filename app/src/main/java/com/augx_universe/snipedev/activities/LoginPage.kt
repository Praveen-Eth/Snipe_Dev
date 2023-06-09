package com.augx_universe.snipedev.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.augx_universe.snipedev.R
import com.augx_universe.snipedev.view_models.AuthViewModel
import com.augx_universe.snipedev.databinding.ActivityLoginPageBinding
import com.google.firebase.auth.FirebaseAuth

class LoginPage : AppCompatActivity(){
  lateinit  var binding: ActivityLoginPageBinding
  private lateinit var authViewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_page)
        authViewModel =  ViewModelProvider(this)
            .get(AuthViewModel::class.java)
        binding.connector = authViewModel
        binding.lifecycleOwner = this


        authViewModel.isLoginSuccess.observe(this, Observer {   isSuccess ->

            if (isSuccess) {
                Toast.makeText(applicationContext, "User Authenticated", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomePage::class.java)
                startActivity(intent)
            }else{

                Toast.makeText(applicationContext, "Failed to Authenticate Try Again Later!", Toast.LENGTH_SHORT).show()
            }
        })

        authViewModel.homepageActivityStarter.observe(this, Observer {
            activityClass -> startActivity(Intent(this,activityClass))
        })


    }

    override fun onStart() {
        super.onStart()
        val user  = FirebaseAuth.getInstance().currentUser
        if (user!=null){
            startActivity(Intent(this,HomePage::class.java))
        }
        else{
            System.out.println("user cant detected , log new one!");
        }
    }




}