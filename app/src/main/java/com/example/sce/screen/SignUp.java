package com.example.sce.screen;

import android.app.DatePickerDialog;
import android.content.Intent;
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
import com.example.sce.db.user.UserDao;
import com.example.sce.db.user.UserHelper;
import com.example.sce.helper.EmailSender;
import com.example.sce.helper.OTPGenerator;
import com.example.sce.model.User;

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

                if (name.isEmpty() || address.isEmpty() || city.isEmpty() || dob.isEmpty() || nic.isEmpty() ||
                        email.isEmpty() || mobile.isEmpty() || gender.isEmpty()) {
                    Toast.makeText(SignUp.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User(name, address, city, dob, nic, email, gender, mobile, "");

                    Intent intent = new Intent(SignUp.this, OTPVerification.class);

                    String OTP = OTPGenerator.generateOTP();
                    String OTP_message = "Hi,\n" + OTP + " is your One-Time Password (OTP) for SCE";

                    EmailSender emailSender = new EmailSender(email, "OTP - verification", OTP_message);
                    emailSender.execute();

                    intent.putExtra("OTP", OTP);
                    intent.putExtra("user", user);

                    startActivity(intent);
                    finish();
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
