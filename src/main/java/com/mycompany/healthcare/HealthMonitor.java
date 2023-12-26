package com.mycompany.healthcare;

import java.io.Serializable;

public class HealthMonitor implements Serializable {

    private User loggedInUser;
    private String dailyHealthReport;

    public HealthMonitor() {
        this.loggedInUser = null;
        this.dailyHealthReport = "";
    }

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public String generateHealthReport() {
        if (loggedInUser != null) {
            double bmi = calculateBMI();
            String activityLevel = calculateActivityLevel();
            String sleepQuality = calculateSleepQuality();
            String nutritionStatus = calculateNutritionStatus();

            String userData = new String("User: " + loggedInUser.getName()
                    + ", Age: " + loggedInUser.getAge()
                    + ", Gender: " + loggedInUser.getGender()
                    + ", Weight: " + loggedInUser.getWeight()
                    + ", Height: " + loggedInUser.getHeight());

            StringBuilder reportBuilder = new StringBuilder("Daily Health Report for " + loggedInUser.getName() + ":\n");
            reportBuilder.append(userData);
            reportBuilder.append("\nBlood Pressure: ").append(loggedInUser.getBloodPressure());
            reportBuilder.append("\nHeart Rate: ").append(loggedInUser.getHeartRate());
            reportBuilder.append("\nVaccination Status: ").append(loggedInUser.getVaccinationStatus());
            reportBuilder.append("\nBMI: ").append(bmi);
            reportBuilder.append("\nActivity Level: ").append(activityLevel);
            reportBuilder.append("\nSleep Quality: ").append(sleepQuality);
            reportBuilder.append("\nNutrition Status: ").append(nutritionStatus);

            dailyHealthReport = reportBuilder.toString();
            return dailyHealthReport;
        } else {
            return "There is no Report for this user";
        }
    }

    private double calculateBMI() {
        if (loggedInUser != null && loggedInUser.getHeight() > 0 && loggedInUser.getWeight() > 0) {
            return loggedInUser.getWeight() / Math.pow(loggedInUser.getHeight(), 2);
        } else {
            return 0;
        }
    }

    private String calculateSleepQuality() {
        double sleepDuration = loggedInUser.getSleepDuration();
        if (sleepDuration >= 7 && sleepDuration <= 9) {
            return "Good";
        } else if (sleepDuration < 7) {
            return "Poor (Insufficient sleep)";
        } else {
            return "Poor (Excessive sleep)";
        }
    }

    private String calculateActivityLevel() {
        double weeklyActivityHours = loggedInUser.getWeeklyActivityHours();

        if (weeklyActivityHours < 2) {
            return "Sedentary";
        } else if (weeklyActivityHours < 5) {
            return "Lightly Active";
        } else if (weeklyActivityHours < 10) {
            return "Moderately Active";
        } else {
            return "Very Active";
        }
    }

    private String calculateNutritionStatus() {
        int servings = loggedInUser.getNutritionDetails();

        if (servings >= 5) {
            return "Excellent";
        } else if (servings >= 3) {
            return "Good";
        } else {
            return "Needs Improvement";
        }
    }

}
