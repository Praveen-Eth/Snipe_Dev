package com.augx_universe.snipedev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.augx_universe.snipedev.databinding.FragmentSignupBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.EmailAuthCredential

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: FragmentSignupBinding
    lateinit var rViewModel: AuthViewModel
    lateinit var weakTextView: TextView
    private lateinit var passwordListener: TextView
    lateinit var monkeyReaction: ImageView
    var isMonkeyOpen: Boolean = true
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

        weakTextView = binding.signUpWeakTextPassword

        passwordListener = binding.passwordInput
        passwordListener.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    if (s.length <= 6){
                    weakTextView.text = "Password length not less than 6 characters! ";
                        weakTextView.setTextColor(resources.getColor(R.color.red))
                    }
                    else{
                        weakTextView.text = "verified"
                        weakTextView.setTextColor(resources.getColor(R.color.green))
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        monkeyReaction = binding.monkeyImage
        monkeyReaction.setImageResource(R.drawable.close_monkey)
        monkeyReaction.setOnClickListener{
            if(isMonkeyOpen){

                monkeyReaction.setImageResource(R.drawable.open_monkey)
                isMonkeyOpen = false
                passwordListener.inputType = InputType.TYPE_CLASS_TEXT
                passwordListener.transformationMethod = HideReturnsTransformationMethod.getInstance()

            }else{

                monkeyReaction.setImageResource(R.drawable.close_monkey)
                isMonkeyOpen = true

                passwordListener.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                passwordListener.transformationMethod = PasswordTransformationMethod.getInstance()
            }
            passwordListener.requestFocus()
            (passwordListener as EditText).setSelection(passwordListener.text.length)
        }
    }
}