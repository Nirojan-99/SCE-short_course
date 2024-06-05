package com.example.sce.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sce.R;
import com.example.sce.model.Course;
import com.example.sce.screen.ViewLocations;

import java.util.List;

public class UserCourseViewAdapter extends RecyclerView.Adapter<UserCourseViewAdapter.CourseViewHolder> {

    private Context context;
    private List<Course> courseList;

    public UserCourseViewAdapter(Context context, List<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_course_details_recycler_view, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = courseList.get(position);

        String dayIdentifier = course.getDuration() > 1 ? " Days" : " Day";
        holder.textViewCourseName.setText(course.getCourseName());
        holder.textViewCourseFee.setText("$ " + String.valueOf(course.getCourseFee()));
        holder.textViewCourseDuration.setText(String.valueOf(course.getDuration()) + dayIdentifier);
        holder.textViewCourseDue.setText("Due : " + course.getRegistrationCloseDate());
        holder.textViewCourseStart.setText("From : " + course.getStartDate());

        holder.imageViewLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double[] latitudes = {37.4219983, 34.052235, 40.712776};
                double[] longitudes = {-122.084, -118.243683, -74.005974};

                Intent intent = new Intent(context, ViewLocations.class);
                intent.putExtra("latitudes", latitudes);
                intent.putExtra("longitudes", longitudes);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    static class CourseViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCourseName, textViewCourseDue, textViewCourseDuration, textViewCourseFee,textViewCourseStart;
        ImageView imageViewLocation;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCourseName = itemView.findViewById(R.id.textViewCourseName);
            imageViewLocation = itemView.findViewById(R.id.imageViewLocation);
            textViewCourseDue = itemView.findViewById(R.id.textViewCourseDue);
            textViewCourseDuration = itemView.findViewById(R.id.textViewCourseDuration);
            textViewCourseFee = itemView.findViewById(R.id.textViewCourseFee);
            textViewCourseStart = itemView.findViewById(R.id.textViewCourseStart);
        }
    }
}
