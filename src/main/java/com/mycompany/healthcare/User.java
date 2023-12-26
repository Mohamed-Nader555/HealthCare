package com.mycompany.healthcare;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private int age;
    private String gender;

    private String bloodPressure;
    private int heartRate;
    private String vaccinationStatus;
    private int nutritionDetails;
    private double weeklyActivityHours;
    private double weight;
    private double height;
    private double sleepDuration;
    
    private String username;
    private String password;

    public User(){
        
    }
    
    public User(String name, int age, String gender, String username, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

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

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
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


    public int getNutritionDetails() {
        return nutritionDetails;
    }

    public void setNutritionDetails(int nutritionDetails) {
        this.nutritionDetails = nutritionDetails;
    }

    public double getWeeklyActivityHours() {
        return weeklyActivityHours;
    }

    public void setWeeklyActivityHours(double weeklyActivityHours) {
        this.weeklyActivityHours = weeklyActivityHours;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSleepDuration() {
        return sleepDuration;
    }

    public void setSleepDuration(double sleepDuration) {
        this.sleepDuration = sleepDuration;
    }

}
