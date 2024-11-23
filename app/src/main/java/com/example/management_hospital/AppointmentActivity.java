package com.example.management_hospital;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AppointmentActivity extends AppCompatActivity {

    private EditText etDate, etMobile, etAge, etPatientName;
    private RadioGroup rgTimeSlot, rgGender;
    private Spinner spinnerDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        // Initialize views
        etDate = findViewById(R.id.etDate);
        etMobile = findViewById(R.id.etMobileNumber);
        etAge = findViewById(R.id.etAge);
        etPatientName = findViewById(R.id.etPatientName);
        rgTimeSlot = findViewById(R.id.rgTimeSlot);
        rgGender = findViewById(R.id.rgGender);
        spinnerDoctor = findViewById(R.id.spinnerDoctor);

        // Configure age field to accept only numeric input and set a max length of 3 digits
        etAge.setInputType(InputType.TYPE_CLASS_NUMBER);
        etAge.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});

        // Populate the spinner with doctor names
        String[] doctors = {
                "Select Doctor",
                "Dr. Shrikant Aware",
                "Dr. Manisha Aware",
                "Dr. Sandip Agwan",
                "Dr. Kunal Mali",
                "Dr. Ruchita Shinde"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, doctors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDoctor.setAdapter(adapter);

        // Set OnClickListener for Date EditText
        etDate.setOnClickListener(v -> showDatePickerDialog());

        // Button to confirm and display the selected data
        Button btnBookAppointment = findViewById(R.id.btnBookAppointment);
        btnBookAppointment.setOnClickListener(v -> {
            // Get inputs
            String patientName = etPatientName.getText().toString().trim();
            String age = etAge.getText().toString().trim();
            String mobileNumber = etMobile.getText().toString().trim();
            int selectedGenderId = rgGender.getCheckedRadioButtonId();
            String gender = selectedGenderId == R.id.rbMale ? "Male" : selectedGenderId == R.id.rbFemale ? "Female" : "";

            // Get the selected time slot
            int selectedTimeId = rgTimeSlot.getCheckedRadioButtonId();
            String timeSlot = "";

            if (selectedTimeId == R.id.rbMorning) {
                timeSlot = "Morning: 9:00 AM - 12:00 PM";
            } else if (selectedTimeId == R.id.rbAfternoon) {
                timeSlot = "Afternoon: 1:00 PM - 3:00 PM";
            } else if (selectedTimeId == R.id.rbEvening) {
                timeSlot = "Evening: 5:00 PM - 9:00 PM";
            }

            // Get the selected date
            String date = etDate.getText().toString().trim();

            // Get the selected doctor
            String selectedDoctor = spinnerDoctor.getSelectedItem().toString();

            // Validate inputs
            if (patientName.isEmpty()) {
                Toast.makeText(this, "Please enter the patient's name", Toast.LENGTH_SHORT).show();
            } else if (age.isEmpty() || !age.matches("\\d+") || Integer.parseInt(age) == 0 || Integer.parseInt(age) > 999) {
                Toast.makeText(this, "Please enter a valid age (1-999)", Toast.LENGTH_SHORT).show();
            } else if (mobileNumber.isEmpty() || mobileNumber.length() != 10 || !mobileNumber.matches("\\d{10}")) {
                Toast.makeText(this, "Please enter a valid 10-digit mobile number", Toast.LENGTH_SHORT).show();
            } else if (gender.isEmpty()) {
                Toast.makeText(this, "Please select a gender", Toast.LENGTH_SHORT).show();
            } else if (date.isEmpty()) {
                Toast.makeText(this, "Please select a date", Toast.LENGTH_SHORT).show();
            } else if (timeSlot.isEmpty()) {
                Toast.makeText(this, "Please select a time slot", Toast.LENGTH_SHORT).show();
            } else if (selectedDoctor.equals("Select Doctor")) {
                Toast.makeText(this, "Please select a doctor", Toast.LENGTH_SHORT).show();
            } else {
                // Display a confirmation message
                Toast.makeText(
                        this,
                        "Appointment booked for:\nPatient: " + patientName +
                                "\nAge: " + age +
                                "\nMobile: " + mobileNumber +
                                "\nGender: " + gender +
                                "\nDoctor: " + selectedDoctor +
                                "\nDate: " + date +
                                "\nTime Slot: " + timeSlot,
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }

    private void showDatePickerDialog() {
        // Get the current date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create and display the DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, selectedYear, selectedMonth, selectedDay) -> {
            String selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
            etDate.setText(selectedDate);
        }, year, month, day);

        datePickerDialog.show();
    }
}
