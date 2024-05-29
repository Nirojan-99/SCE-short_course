package com.example.sce.screen;

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
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {

                    if (username.equals("admin") && password.equals("admin")) {
                        Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
