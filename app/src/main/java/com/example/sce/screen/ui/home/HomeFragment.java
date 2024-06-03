package com.example.sce.screen.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sce.R;
import com.example.sce.adapter.CourseAdapter;
import com.example.sce.model.Course;
import com.example.sce.screen.Branches;
import com.example.sce.screen.Login;
import com.example.sce.screen.NewCourse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private CourseAdapter courseAdapter;
    private List<Course> courseList;
    private Button manageBranchesButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);
        manageBranchesButton = view.findViewById(R.id.manageBranchesButton);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        manageBranchesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Branches.class));
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext(), NewCourse.class));
            }
        });

        courseList = new ArrayList<>();
        String[] branches1 = {"Colombo", "Kandy"};
        String[] branches2 = {"Colombo", "Jaffna"};
        String[] branches3 = {"Galle", "Gampaha"};
        String[] branches4 = {"Kottawa", "Colombo"};
        courseList.add(new Course(
                "Programming for Beginners",
                30000.00,
                branches1,
                10,
                "2024-02-15",
                "2024-02-29",
                "2024-03-15",
                30
        ));
        courseList.add(new Course(
                "Advanced Java Programming",
                45000.00,
                branches2,
                15,
                "2024-02-10",
                "2024-02-24",
                "2024-03-20",
                25
        ));
        courseList.add(new Course(
                "Web Development Essentials",
                40000.00,
                branches3,
                12,
                "2024-02-18",
                "2024-03-01",
                "2024-03-25",
                20
        ));
        courseList.add(new Course(
                "Database Management Systems",
                35000.00,
                branches4,
                8,
                "2024-02-12",
                "2024-02-26",
                "2024-03-18",
                15
        ));

        courseAdapter = new CourseAdapter(courseList, getContext());
        recyclerView.setAdapter(courseAdapter);

        return view;
    }
}