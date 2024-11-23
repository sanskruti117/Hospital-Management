package com.example.management_hospital; // Replace with your package name

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    private EditText nameField, emailField, feedbackField;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback); // Replace with your layout file name

        // Initialize the views
        nameField = findViewById(R.id.nameField);
        emailField = findViewById(R.id.emailField);
        feedbackField = findViewById(R.id.feedbackField);
        submitButton = findViewById(R.id.submitButton);

        // Set onClickListener for the submit button
        submitButton.setOnClickListener(v -> validateInputs());
    }

    private void validateInputs() {
        // Get the text entered by the user
        String name = nameField.getText().toString().trim();
        String email = emailField.getText().toString().trim();
        String feedback = feedbackField.getText().toString().trim();

        // Check if any field is empty
        if (TextUtils.isEmpty(name)) {
            nameField.setError("Name is required");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            emailField.setError("Email is required");
            return;
        }

        // Validate email format
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailField.setError("Please enter a valid email address");
            return;
        }

        if (TextUtils.isEmpty(feedback)) {
            feedbackField.setError("Feedback is required");
            return;
        }

        // If all fields are valid, show a success message
        Toast.makeText(this, "Feedback Submitted Successfully!", Toast.LENGTH_SHORT).show();

        // Optionally, clear the fields after submission
        nameField.setText("");
        emailField.setText("");
        feedbackField.setText("");
    }
}
