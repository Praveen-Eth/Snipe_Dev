package com.augx_universe.snipedev

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.augx_universe.snipedev.Listeners.ActivityStarter
import com.augx_universe.snipedev.Model.UserAuthByEmail

//this view model can handle operations of signup and authentication
class AuthViewModel() : ViewModel()
{
  lateinit var signUpActivity: ActivityStarter
    var userName: String? = null
    var password: String? = null
    var database: UserAuthByEmail = UserAuthByEmail()

  private val _isNewUserCreated = MutableLiveData<Boolean>()
  val isNewUserCreated: LiveData<Boolean> = _isNewUserCreated

  private val _isLoginSuccess = MutableLiveData<Boolean>()
  val isLoginSuccess: LiveData<Boolean> = _isLoginSuccess

    fun updateCredentials(){


      database.signInUsingEmailPassword(userName.toString(),password.toString())
    }
  /**call back function signupIntent() , setActivityStarter() */
    fun signupIntent(){
      signUpActivity.startSignupActivity()
    }
  fun setActivityStarter(_signUpActivity: ActivityStarter){
    signUpActivity   = _signUpActivity
  }




}