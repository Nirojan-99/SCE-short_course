package com.example.sce.screen.ui.userHome;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageButton;
import com.example.sce.R;
import com.example.sce.adapter.UserCourseViewAdapter;
import com.example.sce.model.Course;
import java.util.ArrayList;
import java.util.List;

public class UserHomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private UserCourseViewAdapter courseAdapter;
    private List<Course> courseList;
    private EditText searchVal;
    private ImageButton imageButton;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        searchVal = view.findViewById(R.id.editTextInput);
        //imageButton = view.findViewById(R.id.buttonWithIcon);

        courseList = new ArrayList<>();
        loadCourses();
        courseAdapter = new UserCourseViewAdapter(getActivity(), courseList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(courseAdapter);

//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                filterCourses(searchVal.getText().toString());
//            }
//        });

        searchVal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                filterCourses(searchVal.getText().toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterCourses(searchVal.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                filterCourses(searchVal.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void loadCourses() {
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
    }

    private void filterCourses(String query) {
        List<Course> filteredList = new ArrayList<>();
        if (!TextUtils.isEmpty(query)) {
            for (Course course : courseList) {
                if (course.getCourseName().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(course);
                }
            }
        } else {
            filteredList.addAll(courseList);
        }
        courseAdapter = new UserCourseViewAdapter(getContext(), filteredList);
        recyclerView.setAdapter(courseAdapter);
    }
}