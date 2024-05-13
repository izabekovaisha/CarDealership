package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    private UserInterface() {
        this.initializeDealership();
    }

    /* Private method to create dealership object
     * 1: Create an instance of the DealershipFileManager class
     * 2: Call getDealership method to retrieve the dealership
     * 3. Assign the returned dealership to the UserInterface's this.dealership attribute
     */
    private void initializeDealership() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = DealershipFileManager.getDealership();
    }

    /* Method to display menu and process user commands using a while loop
     * Read the user's command using a scanner
     * Call the correct process() method that matches the user request using switch a statement
     */
    public void display() {
        this.initializeDealership();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("Menu:");
            System.out.println("Request by: ");
            System.out.println("1. Price");
            System.out.println("2. Make and Model");
            System.out.println("3. Year");
            System.out.println("4. Color");
            System.out.println("5. Mileage");
            System.out.println("6. Type");
            System.out.println("7. All vehicles");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("0. Exit");
            System.out.println("Choose an option:");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again!");
                    break;
            }
        }
    }


    private void displayVehicles(List<Vehicle> inventory) {
        for (Vehicle vehicle : inventory) {
            System.out.println(vehicle);
        }
    }

    public void processGetByPriceRequest() {
    }

    public void processGetByMakeModelRequest() {
    }

    public void processGetByYearRequest() {
    }

    public void processGetByColorRequest() {
    }

    public void processGetByMileageRequest() {
    }

    public void processGetByVehicleTypeRequest() {
    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> inventory  = dealership.getAllVehicles();
        displayVehicles(inventory);
    }

    public static void processAddVehicleRequest() {
    }

    public static void processRemoveVehicleRequest() {
    }


}
