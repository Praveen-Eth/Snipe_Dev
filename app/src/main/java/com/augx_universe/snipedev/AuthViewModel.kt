package com.augx_universe.snipedev

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//this view model can handle operations of signup and authentication
class AuthViewModel : ViewModel()
{

    var userName: String? = null
    var password: String? = null

    fun updateCredentials(){

        System.out.println(userName+" "+password);
    }
    fun signupIntent(){
      //  val intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse())
    }




}