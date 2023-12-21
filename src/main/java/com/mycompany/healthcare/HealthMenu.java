package com.mycompany.healthcare;

import java.util.Scanner;

public class HealthMenu {

    private HealthMonitor healthMonitor;
    private User loggedInUser;
    private Scanner scanner;

    public HealthMenu(HealthMonitor healthMonitor) {
        this.healthMonitor = healthMonitor;
        this.scanner = new Scanner(System.in);
        this.loggedInUser = null;
    }

    public void displayMenu() {
        System.out.println("----- Health Monitoring Application -----");
        System.out.println("1. Register");
        System.out.println("2. Log In");
        System.out.println("3. Record Health Data");
        System.out.println("4. View Health Report");
        System.out.println("5. Get Daily Exercise Tip");
        System.out.println("6. Get Daily Diet Tip");
        System.out.println("7. Get Daily Lifestyle Tip");
        System.out.println("8. Exit");
    }

    public void performAction() {
        int choice = getUserChoice();

        switch (choice) {
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            case 3:
                recordHealthData();
                break;
            case 4:
                viewHealthReport();
                break;
            case 5:
                getDailyTip(new ExerciseTip());
                break;
            case 6:
                getDailyTip(new DietTip());
                break;
            case 7:
                getDailyTip(new LifestyleTip());
                break;
            case 8:
                exitApplication();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print("Enter your choice: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void registerUser() {
        System.out.println("----- User Registration -----");
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.print("Enter your gender: ");
        String gender = scanner.next();
        System.out.print("Create a username: ");
        String username = scanner.next();
        System.out.print("Create a password: ");
        String password = scanner.next();

        User newUser = new User(name, age, gender, 0, 0, "Not Vaccinated", username, password);
        healthMonitor.addUser(newUser);
        System.out.println("Registration successful! You can now log in.");
    }

    private void loginUser() {
        System.out.println("----- User Login -----");
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        User user = findUserByUsernameAndPassword(username, password);
        if (user != null) {
            loggedInUser = user;
            healthMonitor.setLoggedInUser(loggedInUser);
            System.out.println("Login successful! Welcome, " + loggedInUser.getName() + "!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private User findUserByUsernameAndPassword(String username, String password) {
        for (User user : healthMonitor.getUsers()) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    private void recordHealthData() {
        if (loggedInUser != null) {
            System.out.println("----- Record Health Data -----");
            System.out.print("Enter your blood pressure: ");
            int bloodPressure = scanner.nextInt();
            System.out.print("Enter your heart rate: ");
            int heartRate = scanner.nextInt();
            System.out.print("Enter your vaccination status (e.g., 'Vaccinated', 'Not Vaccinated'): ");
            String vaccinationStatus = scanner.next();

            healthMonitor.recordHealthData(bloodPressure, heartRate, vaccinationStatus);
            System.out.println("Health data recorded successfully!");
        } else {
            System.out.println("You must log in before recording health data.");
        }
    }

    private void viewHealthReport() {
        if (loggedInUser != null) {
            healthMonitor.generateHealthReport();
            System.out.println("----- Health Report for " + loggedInUser.getName() + " -----");
            System.out.println(healthMonitor.getDailyHealthReport());
        } else {
            System.out.println("You must log in before viewing the health report.");
        }
    }

    private void getDailyTip(HealthTips healthTipProvider) {
        String tip = healthTipProvider.getDailyTip();
        System.out.println("----- Daily Tip -----");
        System.out.println(tip);
    }

    private void exitApplication() {
        System.out.println("Thank you for using the Health Monitoring Application. Goodbye!");
        System.exit(0);
    }
}
