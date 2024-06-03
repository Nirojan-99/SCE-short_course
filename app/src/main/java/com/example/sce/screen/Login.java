package com.example.sce.screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sce.R;

public class Login extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin,btnGuestLogin;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        signup = findViewById(R.id.signupbtn);
        btnLogin = findViewById(R.id.btnLogin);
        btnGuestLogin = findViewById(R.id.btnGuestLogin);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });

        btnGuestLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,UserNavigation.class));
                //TODO add shared pref
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
//                startActivity(new Intent(Login.this, AdminNavigation.class));
//                if (username.isEmpty() || password.isEmpty()) {
//                    Toast.makeText(Login.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
//                } else {
//
//                    if (username.equals("admin") && password.equals("admin")) {
//                        // startActivity(new Intent(Login.this, AdminNavigation.class));
//                        Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
//
//                    } else {
//                        Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
//                    }
//                }
            }
        });
    }
}
