package com.example.sce.screen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sce.R;
import com.example.sce.db.enrollment.EnrollmentDao;
import com.example.sce.helper.DateHelper;
import com.example.sce.helper.PreferenceManager;
import com.example.sce.helper.TimestampGenerator;
import com.example.sce.model.Course;
import com.example.sce.model.Enrollment;

import java.util.List;

public class Payment extends AppCompatActivity {
    private TextView textViewFinalPrice;
    private EditText editTextCardNumber;
    private EditText editTextCardExpiry;
    private EditText editTextCardCVC;
    private Button buttonCompleteCheckout;
    private double finalPrice;
    private List<Course> selectedCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        textViewFinalPrice = findViewById(R.id.textViewFinalPrice);
        editTextCardNumber = findViewById(R.id.editTextCardNumber);
        editTextCardExpiry = findViewById(R.id.editTextCardExpiry);
        editTextCardCVC = findViewById(R.id.editTextCardCVC);
        buttonCompleteCheckout = findViewById(R.id.buttonCompleteCheckout);

        finalPrice = getIntent().getDoubleExtra("totalPrice", 0.0);
        selectedCourses = getIntent().getParcelableArrayListExtra("selectedCourses");
        textViewFinalPrice.setText(String.format("Final Price: $%.2f", finalPrice));

        buttonCompleteCheckout.setOnClickListener(v -> completeCheckout());
    }

    private void completeCheckout() {
        String cardNumber = editTextCardNumber.getText().toString().trim();
        String cardExpiry = editTextCardExpiry.getText().toString().trim();
        String cardCVC = editTextCardCVC.getText().toString().trim();

        if (validateCardDetails(cardNumber, cardExpiry, cardCVC)) {
            EnrollmentDao enrollmentDao = new EnrollmentDao(getApplicationContext());
            String purchaseCode = TimestampGenerator.generateTimestamp();

            PreferenceManager preferenceManager = new PreferenceManager(getApplicationContext());
            String userID = preferenceManager.getUserId();
            String branch = "Jaffna";//TODO

            for (Course course : selectedCourses) {

                Enrollment enrollment = new Enrollment(purchaseCode, Integer.parseInt(userID), (int) course.getId(), branch, DateHelper.getCurrentDate());
                enrollmentDao.insertEnrollment(enrollment);
            }


            Toast.makeText(this, "Payment Successful!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Payment.this, UserNavigation.class));
            finish();
        }
    }

    private boolean validateCardDetails(String cardNumber, String cardExpiry, String cardCVC) {
        if (cardNumber.isEmpty() || cardNumber.length() != 16) {
            Toast.makeText(this, "Invalid Card Number", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (cardExpiry.isEmpty() || !cardExpiry.matches("(0[1-9]|1[0-2])/[0-9]{2}")) {
            Toast.makeText(this, "Invalid Expiry Date", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (cardCVC.isEmpty() || cardCVC.length() != 3) {
            Toast.makeText(this, "Invalid CVC", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
