package com.mycompany.healthcare;

import java.io.Serializable;
import java.util.List;

public class HealthMonitor implements Serializable {

    private static final long serialVersionUID = 1L;

        private List<User> users;
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

    
    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    public void recordHealthData(int bloodPressure, int heartRate, String vaccinationStatus) {
        if (loggedInUser != null) {
            loggedInUser.setBloodPressure(bloodPressure);
            loggedInUser.setHeartRate(heartRate);
            loggedInUser.setVaccinationStatus(vaccinationStatus);
        }
    }

    public void generateHealthReport() {
        if (loggedInUser != null) {
            StringBuilder reportBuilder = new StringBuilder("Daily Health Report for " + loggedInUser.getName() + ":\n");
            reportBuilder.append("\nBlood Pressure: ").append(loggedInUser.getBloodPressure());
            reportBuilder.append("\nHeart Rate: ").append(loggedInUser.getHeartRate());
            reportBuilder.append("\nVaccination Status: ").append(loggedInUser.getVaccinationStatus());
            dailyHealthReport = reportBuilder.toString();
        }
    }

    public void notifyVaccinationDue() {
        if (loggedInUser != null && "Not Vaccinated".equals(loggedInUser.getVaccinationStatus())) {
            System.out.println("Notification: Vaccination is due for user " + loggedInUser.getName());
        }
    }

    public String getDailyHealthReport() {
        return dailyHealthReport;
    }
}
