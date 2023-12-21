package com.mycompany.healthcare;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    // User details
    private String name;
    private int age;
    private String gender;

    // Health parameters
    private int bloodPressure;
    private int heartRate;
    private String vaccinationStatus;

    // Login credentials
    private String username;
    private String password;

    // Constructors
    public User(String name, int age, String gender, int bloodPressure, int heartRate, String vaccinationStatus,
            String username, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.vaccinationStatus = vaccinationStatus;
        this.username = username;
        this.password = password;
    }

    // Getters and setters for user details
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getters and setters for health parameters
    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public String getVaccinationStatus() {
        return vaccinationStatus;
    }

    public void setVaccinationStatus(String vaccinationStatus) {
        this.vaccinationStatus = vaccinationStatus;
    }

    // Getters and setters for login credentials
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
