package com.example.sce.model;

public class Course {
    private String courseName;
    private double courseFee;
    private String[] branches;
    private int duration; // Duration in days
    private String publishedDate;
    private String registrationCloseDate;
    private String startDate;
    private int maxParticipants;

    public Course(String courseName, double courseFee, String[] branches, int duration, String publishedDate, String registrationCloseDate, String startDate, int maxParticipants) {
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.branches = branches;
        this.duration = duration;
        this.publishedDate = publishedDate;
        this.registrationCloseDate = registrationCloseDate;
        this.startDate = startDate;
        this.maxParticipants = maxParticipants;
    }

    public Course() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    public String[] getBranches() {
        return branches;
    }

    public void setBranches(String[] branches) {
        this.branches = branches;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getRegistrationCloseDate() {
        return registrationCloseDate;
    }

    public void setRegistrationCloseDate(String registrationCloseDate) {
        this.registrationCloseDate = registrationCloseDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }
}
