package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    private static final String filename = "dealership.csv";

/* Method to load and read the dealership.csv file
* Using Dealership object, BufferedReader, and parsing
* It also populates the inventory of vehicles
*/
    public Dealership getDealership() {
        Dealership dealership = null;
        List<Vehicle> inventory = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line1;
            String line2 = null;

            while ((line1 = bufferedReader.readLine()) != null) {
                String[] parts = line1.split("\\|");

                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String address = parts[1].trim();
                    String phone = parts[2].trim();
                    dealership = new Dealership(name, address, phone);
                } else if (line2 != null && !line1.equals(line2)) {
                    parts = line2.split("\\|");
                    if (parts.length == 8) {
                        int vin = Integer.parseInt(parts[0].trim());
                        int year = Integer.parseInt(parts[1].trim());
                        String make = parts[2].trim();
                        String model = parts[3].trim();
                        String vehicleType = parts[4].trim();
                        String color = parts[5].trim();
                        int odometer = Integer.parseInt(parts[6].trim());
                        double price = Double.parseDouble(parts[7].trim());

                        inventory.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
                    }
                }
                line2 = line1;
            }

        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
        for (Vehicle vehicle : inventory) {
            dealership.addVehicle(vehicle);
        }
        return dealership;
    }

    // Method to overwrite the dealership.csv file with current dealership information and inventory list
    public void saveDealership(Dealership dealership) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(getDealership().getName() + "|" + getDealership().getAddress() + "|" + getDealership().getPhone());
            writer.newLine();
            writer.close();

            for (Vehicle vehicle : getDealership().getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());
                writer.newLine();
                writer.close();
            }
        } catch (IOException e) {
            System.err.println(("Error writing dealership information: " + e.getMessage()));
        }
    }
    }



