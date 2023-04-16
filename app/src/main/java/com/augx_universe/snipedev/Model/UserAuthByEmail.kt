package com.augx_universe.snipedev.Model

import android.app.AuthenticationRequiredException
import android.content.Context
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class UserAuthByEmail {
    private var mAuth: FirebaseAuth  = FirebaseAuth.getInstance()

    fun createNewUser(email: String, password: String,context: Context){
        mAuth.createUserWithEmailAndPassword(email.toString(),password.toString()).addOnCompleteListener { task ->
            if (task.isSuccessful){

                Toast.makeText(context,"Register Successful",Toast.LENGTH_SHORT)
            }else{

                Toast.makeText(context,"Register Failed try again!",Toast.LENGTH_SHORT)
            }
        }
    }


}