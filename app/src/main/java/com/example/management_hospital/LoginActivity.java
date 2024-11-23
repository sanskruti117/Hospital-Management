package com.example.management_hospital;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.submit_btn);

        // Set login button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validate inputs
                if (validateInputs()) {
                    // If valid, proceed to the next activity
                    Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, DoctorProfileActivity.class); // Replace with your target activity
                    startActivity(intent);
                }
            }
        });
    }

    // Validation function
    private boolean validateInputs() {
        String usernameInput = username.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();

        if (TextUtils.isEmpty(usernameInput)) {
            username.setError("Username cannot be empty");
            username.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(passwordInput)) {
            password.setError("Password cannot be empty");
            password.requestFocus();
            return false;
        }

        // Optional: Add more validation rules, e.g., password length or username pattern
        if (passwordInput.length() < 6) {
            password.setError("Password must be at least 6 characters");
            password.requestFocus();
            return false;
        }

        return true;
    }
}
