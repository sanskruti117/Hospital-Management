package com.example.management_hospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DoctorProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile); // Use your provided XML layout

        // Initialize the CardViews by their IDs
        CardView cardProfile = findViewById(R.id.cardProfile);
        CardView cardSettings = findViewById(R.id.cardSettings);
        CardView cardFacilities = findViewById(R.id.cardFacilities);
        CardView cardFeedback = findViewById(R.id.cardFeedback);


        // Set onClickListeners for each CardView to handle navigation

        // Doctor Profile Card Click Listener
        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Doctor Profile page
                Intent intent = new Intent(DoctorProfileActivity.this, dashboard_doc.class);
                startActivity(intent);
            }
        });

        // Appointment Booking Card Click Listener
        cardSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Appointment Booking page
                Intent intent = new Intent(DoctorProfileActivity.this, AppointmentActivity.class);
                startActivity(intent);
            }
        });

        // Facilities Card Click Listener
        cardFacilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Facilities page
                Intent intent = new Intent(DoctorProfileActivity.this, FacilitiesActivity.class);
                startActivity(intent);
            }
        });

        // Feedback Card Click Listener
        cardFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Feedback page
                Intent intent = new Intent(DoctorProfileActivity.this, FeedbackActivity.class);
                startActivity(intent);
            }
        });

        // Gallery Card Click Listener (Optional, if needed)
//        cardGallery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Redirect to Gallery page
//                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
