package com.augx_universe.snipedev

import android.app.Application
import android.content.Context
import android.content.Intent
import android.media.metrics.Event
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.augx_universe.snipedev.Model.UserAuthByEmail

//this view model can handle operations of signup and authentication
class AuthViewModel() : ViewModel()
{
  lateinit var signUpActivity: ActivityStarter
    var userName: String? = null
    var password: String? = null
  var database: UserAuthByEmail = UserAuthByEmail()


    fun updateCredentials(){

        System.out.println(userName+" "+password);
      database.createNewUser(userName.toString(),password.toString())
    }
  /**call back function signupIntent() , setActivityStarter() */
    fun signupIntent(){
      signUpActivity.startSignupActivity()
    }
  fun setActivityStarter(_signUpActivity: ActivityStarter){
    signUpActivity   = _signUpActivity
  }




}