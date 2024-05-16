package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    // Attributes
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    // Constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    // Getters and setters for accessing and modifying attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Method to get vehicles within a specified price range
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehiclesByPrice = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehiclesByPrice.add(vehicle);
            }
        }
        return vehiclesByPrice;
    }

    // Method to get vehicles by make and model
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> vehiclesByMakeModel = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                vehiclesByMakeModel.add(vehicle);
            }
        }
        return vehiclesByMakeModel;
    }

    // Method to get vehicles within a specified year range
    public List<Vehicle> getVehiclesByYear(double min, double max) {
        List<Vehicle> vehiclesByYear = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                vehiclesByYear.add(vehicle);
            }
        }
        return vehiclesByYear;
    }

    // Method to get vehicles by color
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehiclesByColor = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                vehiclesByColor.add(vehicle);
            }
        }
        return vehiclesByColor;
    }

    // Method to get vehicles by mileage
    public List<Vehicle> getVehiclesByMileage(double min, double max) {
        List<Vehicle> vehiclesByMileage = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                vehiclesByMileage.add(vehicle);
            }
        }
        return vehiclesByMileage;
    }

    // Method to get vehicles by type
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> vehiclesByType = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                vehiclesByType.add(vehicle);
            }
        }
        return vehiclesByType;
    }

    // Method to get all vehicles in the inventory
    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    // Method to add a vehicle to the inventory
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // Method to remove a vehicle from the inventory
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    // Method to get a vehicle by its VIN (Vehicle Identification Number)
    public Vehicle getVehicleByVin(int vin) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vin) {
                return vehicle;
            }
        }
        return null;
    }

}
