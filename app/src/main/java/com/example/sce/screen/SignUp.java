package com.example.sce.screen;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sce.R;

public class SignUp extends AppCompatActivity {

    private EditText etName, etAddress, etCity, etDob, etNic, etEmail, etMobile;
    private RadioGroup rgGender;
    private Button btnSignIn;
    private Calendar calendar;

    int year;
    int month;
    int dayOfMonth;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etCity = findViewById(R.id.etCity);
        etDob = findViewById(R.id.etDob);
        etNic = findViewById(R.id.etNic);
        etEmail = findViewById(R.id.etEmail);
        etMobile = findViewById(R.id.etMobile);
        rgGender = findViewById(R.id.rgGender);
        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String address = etAddress.getText().toString().trim();
                String city = etCity.getText().toString().trim();
                String dob = etDob.getText().toString().trim();
                String nic = etNic.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String mobile = etMobile.getText().toString().trim();

                int selectedGenderId = rgGender.getCheckedRadioButtonId();
                RadioButton selectedGenderButton = findViewById(selectedGenderId);
                String gender = selectedGenderButton != null ? selectedGenderButton.getText().toString() : "";

                // Perform validation and handle sign-in logic
                if (name.isEmpty() || address.isEmpty() || city.isEmpty() || dob.isEmpty() || nic.isEmpty() ||
                        email.isEmpty() || mobile.isEmpty() || gender.isEmpty()) {
                    Toast.makeText(SignUp.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Handle sign-in logic here
                    Toast.makeText(SignUp.this, "Sign-In Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        etDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickDate(v);
            }
        });

    }

    // date picker
    public void pickDate(View v) {
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        // Toast.makeText(this, year+"/"+(month+1)+"/"+dayOfMonth, Toast.LENGTH_SHORT).show();
        datePickerDialog = new DatePickerDialog(SignUp.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                etDob.setText(day + "/" + (month + 1) + "/" + year);

            }
        }, year, month, dayOfMonth);
        datePickerDialog.show();
    }
}
