package com.augx_universe.snipedev

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//this view model can handle operations of signup and authentication
class AuthViewModel : ViewModel()
{

    var userName: String? = null
    var password: String? = null

    fun updateCredentials(view: View){
        print(userName+ password)

    }



}