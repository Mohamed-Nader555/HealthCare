package com.mycompany.healthcare;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HealthCare {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FilesStorage fileStorage = new FilesStorage();
        List<User> users = fileStorage.readUsersFromFile();
        User loggedInUser = null;
        HealthMonitor healthMonitor = new HealthMonitor();
        HealthReports healthReports = fileStorage.readReportsFromFile();

        while (true) {

            System.out.println("----- Health Monitoring Application -----");
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Record Health Data");
            System.out.println("4. View Health Report");
            System.out.println("5. Get Daily Exercise Tip");
            System.out.println("6. Get Daily Diet Tip");
            System.out.println("7. Get Daily Lifestyle Tip");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    System.out.println("----- User Registration -----");
                    System.out.print("Enter your name: ");
                    String name = scanner.next();
                    System.out.print("Enter your age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter your gender: (M) OR (F) ");
                    String gender = scanner.next();
                    System.out.print("Create a username: ");
                    String usernameReg = scanner.next();
                    System.out.print("Create a password: ");
                    String passwordReg = scanner.next();

                    User newUser = new User(name, age, gender, usernameReg, passwordReg);
                    users.add(newUser);
                    fileStorage.writeUsersToFile(users);
                    System.out.println("Registration successful! You can now log in.");

                    break;
                case 2:

                    System.out.println("----- User Login -----");
                    System.out.print("Enter your username: ");
                    String usernameLogin = scanner.next();
                    System.out.print("Enter your password: ");
                    String passwordLogin = scanner.next();

                    User user = null;

                    for (User userElement : users) {
                        if (usernameLogin.equals(userElement.getUsername()) && passwordLogin.equals(userElement.getPassword())) {
                            user = userElement;
                        }
                    }
                    if ("admin".equals(usernameLogin) && "admin".equals(passwordLogin)) {
                        System.out.println("Admin login successful!");
                        System.out.println("----- View Health Reports for All Users -----");
                        for (String report : healthReports.getReports()) {
                            System.out.println("Report: " + report);
                            System.out.println("------------------------------------");
                        }

                    } else if (user != null) {
                        loggedInUser = user;
                        healthMonitor.setLoggedInUser(loggedInUser);
                        System.out.println("Login successful! Welcome, " + loggedInUser.getName() + "!");
                    } else {
                        System.out.println("Invalid username or password. Please try again.");
                    }

                    break;
                case 3:

                    if (loggedInUser != null) {
                        System.out.println("----- Record Health Data -----");

                        System.out.print("Enter your blood pressure: ");
                        String bloodPressure = scanner.nextLine();
                        loggedInUser.setBloodPressure(bloodPressure);

                        System.out.print("Enter your heart rate: ");
                        int heartRate = scanner.nextInt();
                        loggedInUser.setHeartRate(heartRate);

                        System.out.print("Choose your vaccination status:\n1. Vaccinated\n2. Not Vaccinated\nEnter the corresponding number: ");
                        String vaccinationStatus = "";

                        int vaccinationChoice = scanner.nextInt();

                        switch (vaccinationChoice) {
                            case 1:
                                loggedInUser.setVaccinationStatus("Vaccinated");
                                vaccinationStatus = "Vaccinated";
                                break;
                            case 2:
                                loggedInUser.setVaccinationStatus("Not Vaccinated");
                                vaccinationStatus = "Not Vaccinated";
                                break;
                            default:
                                System.out.println("Invalid vaccination status choice. Setting to unknown.");
                                loggedInUser.setVaccinationStatus("Unknown");
                                vaccinationStatus = "Unknown";
                                break;
                        }

                        System.out.print("Enter the number of servings of fruits and vegetables: ");
                        int servings = scanner.nextInt();
                        loggedInUser.setNutritionDetails(servings);

                        System.out.print("Enter the number of hours you engage in physical activity per week: ");
                        double activityHours = scanner.nextDouble();
                        loggedInUser.setWeeklyActivityHours(activityHours);

                        System.out.print("Enter your weight in kilograms: ");
                        double weight = scanner.nextDouble();
                        loggedInUser.setWeight(weight);
                        System.out.print("Enter your height in meters: ");
                        double height = scanner.nextDouble();
                        loggedInUser.setHeight(height);

                        System.out.print("Enter your sleep duration in hours: ");
                        double sleepDuration = scanner.nextDouble();
                        loggedInUser.setSleepDuration(sleepDuration);

                        String report = healthMonitor.generateHealthReport();

                        healthReports.addReport(report);
                        fileStorage.writeReportsToFile(healthReports);

                        System.out.println("Health data recorded successfully!");
                    } else {
                        System.out.println("You must log in before recording health data.");
                    }

                    break;
                case 4:

                    if (loggedInUser != null) {

                        System.out.println("----- Health Report for " + loggedInUser.getName() + " -----");
                        System.out.println(healthMonitor.generateHealthReport());
                    } else {
                        System.out.println("You must log in before viewing the health report.");
                    }

                    break;
                case 5:

                    String exerciseTip = new ExerciseTip().getDailyTip();
                    System.out.println("----- Daily Tip -----");
                    System.out.println(exerciseTip);

                    break;
                case 6:

                    String dietTip = new DietTip().getDailyTip();
                    System.out.println("----- Daily Tip -----");
                    System.out.println(dietTip);
                    break;
                case 7:

                    String lifestyleTip = new LifestyleTip().getDailyTip();
                    System.out.println("----- Daily Tip -----");
                    System.out.println(lifestyleTip);

                    break;
                case 8:
                    fileStorage.writeUsersToFile(users);
                    System.out.println("Thank you for using the Health Care Application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

}
