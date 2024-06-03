package com.example.sce.model;

public class Branch {
    private String branchCode;
    private String branchName;

    public Branch(String branchCode, String branchName) {
        this.branchCode = branchCode;
        this.branchName = branchName;
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

    @Override
    public String toString() {
        return "Branch{" +
                "branchCode='" + branchCode + '\'' +
                ", branchName='" + branchName + '\'' +
                '}';
    }
}
