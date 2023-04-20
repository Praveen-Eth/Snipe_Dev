package com.augx_universe.snipedev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.augx_universe.snipedev.databinding.FragmentSignupBinding
import com.google.android.material.snackbar.Snackbar

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: FragmentSignupBinding
    lateinit var rViewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.fragment_signup)
        rViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.bind = rViewModel
        binding.lifecycleOwner = this

        rViewModel.isNewUserCreated.observe(this){task ->
            if (task){
                Toast.makeText(applicationContext,"new User Created",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,LoginPage::class.java)
                startActivity(intent)
            }else{

                Toast.makeText(applicationContext,"unable to create new User try Again or check Internet Connection",Toast.LENGTH_SHORT).show()
            }

        }

    }
}