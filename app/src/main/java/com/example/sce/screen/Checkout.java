package com.example.sce.screen;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sce.R;
import com.example.sce.adapter.UserCourseViewAdapter;
import com.example.sce.model.Course;
import java.util.List;

public class Checkout extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserCourseViewAdapter courseAdapter;
    private List<Course> selectedCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        recyclerView = findViewById(R.id.recyclerViewCheckout);

        selectedCourses = getIntent().getParcelableArrayListExtra("selectedCourses");
        courseAdapter = new UserCourseViewAdapter(this, selectedCourses);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(courseAdapter);
    }
}
