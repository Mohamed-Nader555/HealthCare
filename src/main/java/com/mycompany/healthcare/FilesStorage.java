package com.mycompany.healthcare;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilesStorage {

    private static final String USERS_FILE = "users.dat";
    private static final String HEALTH_REPORT_FILE = "health_reports.dat";
    
    public List<User> readUsersFromFile() {
        List<User> users = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            users = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading user data from file: " + e.getMessage());
        }

        return users;
    }

    public void writeUsersToFile(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.out.println("Error writing user data to file: " + e.getMessage());
        }
    }

    public void writeReportsToFile(HealthReports healthReports) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(HEALTH_REPORT_FILE))) {
            oos.writeObject(healthReports);
        } catch (IOException e) {
            System.out.println("Error writing health reports to file: " + e.getMessage());
        }
    }

    public HealthReports readReportsFromFile() {
        HealthReports healthReports = new HealthReports();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(HEALTH_REPORT_FILE))) {
            healthReports = (HealthReports) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading health reports from file: " + e.getMessage());
        }

        return healthReports;
    }
    
}
