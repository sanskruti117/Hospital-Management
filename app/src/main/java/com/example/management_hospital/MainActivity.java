package com.example.management_hospital;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.management_hospital.DoctorProfileActivity;
import com.example.management_hospital.LoginActivity;
import com.example.management_hospital.R;

public class MainActivity extends AppCompatActivity {

    // Declare views
    private Button btnSignUp;
    private Button btnLogin;
    private TextView btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        btnSignUp = findViewById(R.id.buttonSignUp);
        btnLogin = findViewById(R.id.buttonLogin);
        btnSkip = findViewById(R.id.textView6);

        // Set click listener for Sign Up button
        btnSignUp.setOnClickListener(view -> {
            // Navigate to Registration Activity
            Intent intent = new Intent(this, Registration_Activity.class);
            startActivity(intent);
        });

        // Set click listener for Log In button
        btnLogin.setOnClickListener(view -> {
            // Navigate to Login Activity
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        // Set click listener for Skip button
        btnSkip.setOnClickListener(view -> {
            // Navigate to Dashboard or Home Activity (Example: DoctorProfileActivity)
            Intent intent = new Intent(MainActivity.this, DoctorProfileActivity.class);
            startActivity(intent);
        });
    }
}
