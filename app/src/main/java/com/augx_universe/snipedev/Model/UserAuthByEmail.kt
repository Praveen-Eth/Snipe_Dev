package com.augx_universe.snipedev.Model

import android.app.AuthenticationRequiredException
import android.content.Context
import android.widget.Toast
import com.augx_universe.snipedev.Listeners.AuthListeners
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class UserAuthByEmail {
    private var mAuth: FirebaseAuth  = FirebaseAuth.getInstance()

    fun createNewUser(email: String, password: String): Boolean{

        var isSuccess: Boolean  = false
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            isSuccess = task.isSuccessful
        }
        return isSuccess
    }
    fun signInUsingEmailPassword(email: String,password: String): Boolean{
         var isSuccess: Boolean  = false
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            isSuccess = task.isSuccessful
        }
        return isSuccess
    }


}