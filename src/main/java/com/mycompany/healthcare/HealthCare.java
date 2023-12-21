package com.mycompany.healthcare;

import java.util.List;

public class HealthCare {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        List<User> users = fileHandler.readUsersFromFile();
        HealthMonitor healthMonitor = fileHandler.readHealthMonitorFromFile();
        healthMonitor.setUsers(users);

        HealthMenu healthMenu = new HealthMenu(healthMonitor);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Save user and health monitor data to files before exiting
            fileHandler.writeUsersToFile(healthMonitor.getUsers());
            fileHandler.writeHealthMonitorToFile(healthMonitor);
        }));

        while (true) {
            healthMenu.displayMenu();
            healthMenu.performAction();
        }
    }
}
