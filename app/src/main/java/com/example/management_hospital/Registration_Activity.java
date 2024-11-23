package com.example.management_hospital;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registration_Activity extends AppCompatActivity {

    // Declare views
    EditText edUsername, edEmail, edPassword, edConfirmPassword;
    Button btnRegister;
    TextView btnSkip, alreadyHaveAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration); // Ensure the layout matches your XML file name

        // Enable edge-to-edge content
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        edUsername = findViewById(R.id.editTextUsername);
        edEmail = findViewById(R.id.editTextEmail);
        edPassword = findViewById(R.id.editTextPassword);
        edConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        btnRegister = findViewById(R.id.buttonSubmit);
        btnSkip = findViewById(R.id.textView4); // Initialize the SKIP button
        alreadyHaveAccount = findViewById(R.id.textView3); // Initialize the "Already have an account" text view

        // Set click listener for the SKIP button
        btnSkip.setOnClickListener(view -> {
            Intent intent = new Intent(this, DoctorProfileActivity.class);
            startActivity(intent);
        });

        // Set click listener for the "Already have an account" text
        alreadyHaveAccount.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

        // Set click listener for the register button
        btnRegister.setOnClickListener(view -> {
            if (!validateInputs()) {
                return;
            }

            // Registration successful
            Toast.makeText(Registration_Activity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
        });
    }

    private boolean validateInputs() {
        // Validate fields using helper methods
        if (isFieldEmpty(edUsername, "Username is required")) return false;
        if (isFieldEmpty(edEmail, "Email is required")) return false;
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(edEmail.getText().toString().trim()).matches()) {
            edEmail.setError("Enter a valid email");
            edEmail.requestFocus();
            return false;
        }
        if (isFieldEmpty(edPassword, "Password is required")) return false;
        if (edPassword.getText().toString().length() < 6) {
            edPassword.setError("Password must be at least 6 characters");
            edPassword.requestFocus();
            return false;
        }
        if (isFieldEmpty(edConfirmPassword, "Please confirm your password")) return false;
        if (!edPassword.getText().toString().equals(edConfirmPassword.getText().toString())) {
            edConfirmPassword.setError("Passwords do not match");
            edConfirmPassword.requestFocus();
            return false;
        }
        return true;
    }

    private boolean isFieldEmpty(EditText field, String errorMessage) {
        if (field.getText().toString().trim().isEmpty()) {
            field.setError(errorMessage);
            field.requestFocus();
            return true;
        }
        return false;
    }
}
