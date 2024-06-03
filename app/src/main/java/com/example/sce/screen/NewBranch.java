package com.example.sce.screen;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sce.R;

public class NewBranch extends AppCompatActivity {

    private EditText etBranchCode;
    private EditText etBranchName;
    private Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_branch);

        etBranchCode = findViewById(R.id.etBranchCode);
        etBranchName = findViewById(R.id.etBranchName);
        btnSave = findViewById(R.id.btnSave);

        String branchCode = getIntent().getStringExtra("branchCode");
        String branchName = getIntent().getStringExtra("branchName");

        if(branchName == null){
            btnSave.setText("Add");
        }

        if (!TextUtils.isEmpty(branchCode) && !TextUtils.isEmpty(branchName)) {
            etBranchCode.setText(branchCode);
            etBranchName.setText(branchName);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBranch();
            }
        });
    }

    private void saveBranch() {
        String branchCode = etBranchCode.getText().toString().trim();
        String branchName = etBranchName.getText().toString().trim();

        if (branchCode.isEmpty() || branchName.isEmpty()) {
            Toast.makeText(NewBranch.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            // Save the branch information (e.g., to a database or shared preferences)
            Toast.makeText(NewBranch.this, "Branch saved", Toast.LENGTH_SHORT).show();
            // Optionally, you can finish the activity or perform other actions
            finish();
        }
    }
}
