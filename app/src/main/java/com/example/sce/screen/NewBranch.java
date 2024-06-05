package com.example.sce.screen;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sce.R;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;

public class NewBranch extends AppCompatActivity {

    private EditText etBranchCode;
    private EditText etBranchName;
    private Button btnSave;
    private static final int AUTOCOMPLETE_REQUEST_CODE = 1;
    private Button buttonSelectLocation;

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

        Places.initialize(getApplicationContext(), getString(R.string.google_maps_key));

        Button buttonSelectLocation = findViewById(R.id.button_select_location);

        buttonSelectLocation.setOnClickListener(view -> openAutocompleteActivity());
    }

    private void openAutocompleteActivity() {
        // Set the fields to specify which types of place data to return.
        List<Place.Field> fields = Arrays.asList(
                com.google.android.libraries.places.api.model.Place.Field.ID,
                com.google.android.libraries.places.api.model.Place.Field.NAME,
                com.google.android.libraries.places.api.model.Place.Field.LAT_LNG
        );

        // Start the autocomplete intent.
        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                .build(this);
        startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                com.google.android.libraries.places.api.model.Place place = Autocomplete.getPlaceFromIntent(data);
                LatLng latLng = place.getLatLng();
                if (latLng != null) {
                    //textViewLocation.setText("Selected Location: " + latLng.latitude + ", " + latLng.longitude);
                }
            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                // TODO: Handle the error.
            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
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
