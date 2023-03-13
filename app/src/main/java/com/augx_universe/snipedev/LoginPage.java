package com.augx_universe.snipedev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class LoginPage extends AppCompatActivity {
    CardView email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        email = findViewById(R.id.userName);
        email.setBackgroundResource(R.drawable.card_backgorund);
        password = findViewById(R.id.password);
        password.setBackgroundResource(R.drawable.card_backgorund);
    }
}