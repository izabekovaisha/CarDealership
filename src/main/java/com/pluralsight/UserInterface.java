package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
    }

    /* Private method to create dealership object
     * 1: Create an instance of the DealershipFileManager class
     * 2: Call getDealership method to retrieve the dealership
     * 3. Assign the returned dealership to the UserInterface's this.dealership attribute
     */
    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    /* Method to display menu and process user commands using a while loop
     * Read the user's command using a scanner
     * Call the correct process() method that matches the user request using switch a statement
     */
    public void display() {
        this.init();
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter minimum price of the vehicle: ");
        double minimumPrice = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter maximum price of the vehicle: ");
        double maximumPrice = Double.parseDouble(scanner.nextLine());

        List<Vehicle> inventory = dealership.getVehiclesByPrice(minimumPrice, maximumPrice);
        displayVehicles(inventory);
    }

    public void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter make of the vehicle: ");
        String make = scanner.nextLine();

        System.out.println("Enter model of the vehicle: ");
        String model = scanner.nextLine();

        List<Vehicle> inventory = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(inventory);

    }

    public void processGetByYearRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter minimum year of the vehicle: ");
        double minimumYear = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter maximum year of the vehicle: ");
        double maximumYear = Double.parseDouble(scanner.nextLine());

        List<Vehicle> inventory = dealership.getVehiclesByYear(minimumYear, maximumYear);
        displayVehicles(inventory);
    }

    public void processGetByColorRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter color of the vehicle: ");
        String color = scanner.nextLine();

        List<Vehicle> inventory = dealership.getVehiclesByColor(color);
        displayVehicles(inventory);

    }

    public void processGetByMileageRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter minimum mileage of the vehicle: ");
        double minimumMileage = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter maximum mileage of the vehicle: ");
        double maximumMileage = Double.parseDouble(scanner.nextLine());

        List<Vehicle> inventory = dealership.getVehiclesByMileage(minimumMileage, maximumMileage);
        displayVehicles(inventory);
    }

    public void processGetByVehicleTypeRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter type of the vehicle: ");
        String type = scanner.nextLine();

        List<Vehicle> inventory = dealership.getVehiclesByType(type);
        displayVehicles(inventory);
    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> inventory  = dealership.getAllVehicles();
        displayVehicles(inventory);
    }

    public void processAddVehicleRequest() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter make: ");
        String make = scanner.nextLine();

        System.out.println("Enter model: ");
        String model = scanner.nextLine();

        System.out.println("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        System.out.println("Enter color: ");
        String color = scanner.nextLine();

        System.out.println("Enter odometer: ");
        int odometer = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle addVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(addVehicle);
        dealershipFileManager.saveDealership(dealership);

        System.out.println("Vehicle added successfully!");
    }

    public void processRemoveVehicleRequest() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the VIN of the vehicle you want to remove: ");
        int vin = Integer.parseInt(scanner.nextLine().trim());

        Vehicle removeVehicleRequest = dealership.getVehicleByVin(vin);

        if (removeVehicleRequest != null) {
            dealership.removeVehicle(removeVehicleRequest);
            dealershipFileManager.saveDealership(dealership);
            System.out.println("Vehicle removed successfully!");
        } else {
            System.out.println("Vehicle with " + vin + "vin not found");
        }
        }
        }




