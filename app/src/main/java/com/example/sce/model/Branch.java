package com.example.sce.model;

public class Branch {
    private String branchCode;
    private String branchName;
    private double longitude ;
    private double latitude;

    public Branch() {
    }

    public Branch(String branchCode, String branchName) {
        this.branchCode = branchCode;
        this.branchName = branchName;
    }

    public Branch(String branchCode, String branchName, double longitude, double latitude) {
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
