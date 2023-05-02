package com.augx_universe.snipedev

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.augx_universe.snipedev.Listeners.ActivityStarter
import com.augx_universe.snipedev.Model.UserAuthByEmail

//this view model can handle operations of signup and authentication
class AuthViewModel() : ViewModel()
{

    var emailId: String? = null
    var password: String? = null
    var database: UserAuthByEmail = UserAuthByEmail()
    var homepageActivityStarter = MutableLiveData<Class<out AppCompatActivity>>().apply {
    }


  private var _isNewUserCreated = MutableLiveData<Boolean>()
  val isNewUserCreated: LiveData<Boolean> = _isNewUserCreated

  private var _isLoginSuccess = MutableLiveData<Boolean>()
  var isLoginSuccess: LiveData<Boolean> = _isLoginSuccess

    fun updateCredentials(){


       database.signInUsingEmailPassword(emailId.toString(),password.toString()).observeForever { _isLoginSuccess.postValue(it) }
    }
   fun newUserUpdater(){
     database.createNewUser(emailId.toString(),password = password.toString()).observeForever{_isNewUserCreated.postValue(it)}
   }

    fun switchToSignUpActivity(){
        homepageActivityStarter.value = SignUpActivity::class.java

    }


}