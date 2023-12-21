package com.mycompany.healthcare;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String USERS_FILE = "users.dat";
    private static final String HEALTH_MONITOR_FILE = "health_monitor.dat";

    public List<User> readUsersFromFile() {
        List<User> users = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            users = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Handle exceptions (e.g., file not found, class not found)
            System.out.println("Error reading user data from file: " + e.getMessage());
        }

        return users;
    }

    public void writeUsersToFile(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            // Handle exceptions (e.g., file not found)
            System.out.println("Error writing user data to file: " + e.getMessage());
        }
    }

    public HealthMonitor readHealthMonitorFromFile() {
        HealthMonitor healthMonitor = new HealthMonitor();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(HEALTH_MONITOR_FILE))) {
            healthMonitor = (HealthMonitor) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Handle exceptions (e.g., file not found, class not found)
            System.out.println("Error reading health monitor data from file: " + e.getMessage());
        }

        return healthMonitor;
    }

    public void writeHealthMonitorToFile(HealthMonitor healthMonitor) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(HEALTH_MONITOR_FILE))) {
            oos.writeObject(healthMonitor);
        } catch (IOException e) {
            // Handle exceptions (e.g., file not found)
            System.out.println("Error writing health monitor data to file: " + e.getMessage());
        }
    }
}
