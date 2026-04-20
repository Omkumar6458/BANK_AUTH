package com.example.demo.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String username;
    private String password;
    private String branchId;
    private String employeeCode;
    private String phoneNumber;
    private String email;
    
/*
    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for branchId
    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    // Getter and Setter for employeeCode
    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    // toString()
    @Override
    public String toString() {
        return "RegisterRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", branchId='" + branchId + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }

    // equals() and hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegisterRequest that = (RegisterRequest) o;

        if (!username.equals(that.username)) return false;
        if (!password.equals(that.password)) return false;
        if (!branchId.equals(that.branchId)) return false;
        return employeeCode.equals(that.employeeCode);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + branchId.hashCode();
        result = 31 * result + employeeCode.hashCode();
        return result;
    }
    */
}