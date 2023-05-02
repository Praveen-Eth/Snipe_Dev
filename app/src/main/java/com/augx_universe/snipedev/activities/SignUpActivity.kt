package com.augx_universe.snipedev.activities

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
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.augx_universe.snipedev.R
import com.augx_universe.snipedev.view_models.AuthViewModel
import com.augx_universe.snipedev.databinding.FragmentSignupBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: FragmentSignupBinding
    lateinit var rViewModel: AuthViewModel
    lateinit var weakTextView: TextView
    private lateinit var passwordListener: TextView
    private lateinit var weakEmailTextView: TextView
    lateinit var monkeyReaction: ImageView
    var isMonkeyOpen: Boolean = true
    lateinit var weakEmailAuthCredential: TextView
    val emailPatternMatcher: Regex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_signup)
        rViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.bind = rViewModel
        binding.lifecycleOwner = this

        rViewModel.isNewUserCreated.observe(this){task ->
            if (task){
                Toast.makeText(applicationContext,"new User Created",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginPage::class.java)
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
                        weakTextView.setTextColor(ContextCompat.getColor(applicationContext,
                            R.color.red
                        ));
                    }
                    else{
                        weakTextView.text = "verified"
                        weakTextView.setTextColor(ContextCompat.getColor(applicationContext,
                            R.color.green
                        ))
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

        weakEmailAuthCredential = binding.EmailInput
        weakEmailTextView = binding.signupEmailVerification

        weakEmailAuthCredential.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    if (s.toString().trim().matches(emailPatternMatcher)){
                        weakEmailTextView.text = "valid Email "
                        weakEmailTextView.setTextColor(ContextCompat.getColor(applicationContext,
                            R.color.green
                        ))
                    }
                    else{
                        weakEmailTextView.text = "invalid Email"
                        weakEmailTextView.setTextColor(ContextCompat.getColor(applicationContext,
                            R.color.red
                        ))
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

    }
}