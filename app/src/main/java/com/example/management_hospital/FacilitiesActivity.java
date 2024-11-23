package com.example.management_hospital;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.TextView;

public class FacilitiesActivity extends AppCompatActivity {

    // Declare views
    private TextView tvHeader;
    private TextView tvEmergencyServices;
    private TextView tvMedicalStaff;
    private TextView tvLaboratoryFacilities;
    private TextView tvRadiologyFacilities;
    private TextView tvInpatientFacilities;
    private TextView tvOutpatientDepartments;
    private TextView tvSpecialtyDepartments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities);  // The XML layout file

        // Initialize views
        tvHeader = findViewById(R.id.tvHeader);
        tvEmergencyServices = findViewById(R.id.tvEmergencyServices);
        tvMedicalStaff = findViewById(R.id.tvMedicalStaff);
        tvLaboratoryFacilities = findViewById(R.id.tvLaboratoryFacilities);
        tvRadiologyFacilities = findViewById(R.id.tvRadiologyFacilities);
        tvInpatientFacilities = findViewById(R.id.tvInpatientFacilities);
        tvOutpatientDepartments = findViewById(R.id.tvOutpatientDepartments);
        tvSpecialtyDepartments = findViewById(R.id.tvSpecialtyDepartments);

        // Set any text or listeners if required (for example, setting a custom text)
        tvHeader.setText("Our Facilities");

        // Optionally, set more customized content or listeners on the text views
        tvEmergencyServices.setOnClickListener(v -> {
            // Handle click for Emergency Services TextView
        });

        tvMedicalStaff.setOnClickListener(v -> {
            // Handle click for Medical Staff TextView
        });

        tvLaboratoryFacilities.setOnClickListener(v -> {
            // Handle click for Laboratory Facilities TextView
        });

        tvRadiologyFacilities.setOnClickListener(v -> {
            // Handle click for Radiology Facilities TextView
        });

        tvInpatientFacilities.setOnClickListener(v -> {
            // Handle click for Inpatient Facilities TextView
        });

        tvOutpatientDepartments.setOnClickListener(v -> {
            // Handle click for Outpatient Departments TextView
        });

        tvSpecialtyDepartments.setOnClickListener(v -> {
            // Handle click for Specialty Departments TextView
        });
    }
}
