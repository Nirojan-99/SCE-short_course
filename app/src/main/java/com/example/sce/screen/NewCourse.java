package com.example.sce.screen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sce.R;
import com.example.sce.helper.DateHelper;
import com.example.sce.model.Course;

public class NewCourse extends AppCompatActivity {

    private EditText editTextCourseName;
    private EditText editTextCourseFee;
    private EditText editTextBranches;
    private EditText editTextDuration;
    private EditText editTextRegistrationCloseDate;
    private EditText editTextStartDate;
    private EditText editTextMaxParticipants;
    private Button buttonAddCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_course);

        editTextCourseName = findViewById(R.id.editTextCourseName);
        editTextCourseFee = findViewById(R.id.editTextCourseFee);
        editTextBranches = findViewById(R.id.editTextBranches);
        editTextDuration = findViewById(R.id.editTextDuration);
        editTextRegistrationCloseDate = findViewById(R.id.editTextRegistrationCloseDate);
        editTextStartDate = findViewById(R.id.editTextStartDate);
        editTextMaxParticipants = findViewById(R.id.editTextMaxParticipants);
        buttonAddCourse = findViewById(R.id.buttonAddCourse);

        buttonAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewCourse();
            }
        });
    }

    private void addNewCourse() {
        String courseName = editTextCourseName.getText().toString();
        String courseFeeStr = editTextCourseFee.getText().toString();
        String branchesStr = editTextBranches.getText().toString();
        String durationStr = editTextDuration.getText().toString();
        String publishedDate = DateHelper.getCurrentDate();
        String registrationCloseDate = editTextRegistrationCloseDate.getText().toString();
        String startDate = editTextStartDate.getText().toString();
        String maxParticipantsStr = editTextMaxParticipants.getText().toString();

        if (courseName.isEmpty() || courseFeeStr.isEmpty() || branchesStr.isEmpty() || durationStr.isEmpty() ||
                publishedDate.isEmpty() || registrationCloseDate.isEmpty() || startDate.isEmpty() || maxParticipantsStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double courseFee = Double.parseDouble(courseFeeStr);
        String[] branches = branchesStr.split(",");
        int duration = Integer.parseInt(durationStr);
        int maxParticipants = Integer.parseInt(maxParticipantsStr);

        Course course =  new Course(courseName, courseFee, branches, duration, publishedDate, registrationCloseDate, startDate, maxParticipants);

        Toast.makeText(this, "Course added successfully", Toast.LENGTH_SHORT).show();
        clearFields();
    }

    private void clearFields() {
        editTextCourseName.setText("");
        editTextCourseFee.setText("");
        editTextBranches.setText("");
        editTextDuration.setText("");
        editTextRegistrationCloseDate.setText("");
        editTextStartDate.setText("");
        editTextMaxParticipants.setText("");
    }
}