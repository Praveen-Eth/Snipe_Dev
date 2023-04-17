package com.augx_universe.snipedev

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.augx_universe.snipedev.Listeners.ActivityStarter
import com.augx_universe.snipedev.Listeners.AuthListeners
import com.augx_universe.snipedev.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity(), ActivityStarter {
  lateinit  var binding: ActivityLoginPageBinding
  private lateinit var authViewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login_page)
        authViewModel =  ViewModelProvider(this)
            .get(AuthViewModel::class.java)
        binding.connector = authViewModel
        binding.lifecycleOwner = this
        authViewModel.setActivityStarter(this)

        authViewModel.isLoginSuccess.observe(this) { isSuccess ->
            if (isSuccess) {
                Toast.makeText(this, "User Authenticated", Toast.LENGTH_SHORT).show()
            }else{

                Toast.makeText(this, "Failed to create new user Try Again Later!", Toast.LENGTH_SHORT).show()
            }
        }


    }

    //callback function link@ AuthViewModel
    override fun startSignupActivity() {
        val intent: Intent  =  Intent(this,SignUpActivity::class.java)
        startActivity(intent)

    }


}