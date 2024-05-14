package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

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

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                inventory.add(vehicle);
            }
        }
        return inventory;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make)&& vehicle.getModel().equalsIgnoreCase(model)) {
                inventory.add(vehicle);
            }
        }
        return inventory;
    }

    public List<Vehicle> getVehiclesByYear(double min, double max){
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                inventory.add(vehicle);
            }
        }
        return inventory;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                inventory.add(vehicle);
            }
        }
        return inventory;
    }

    public List<Vehicle> getVehiclesByMileage(double min, double max){
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                inventory.add(vehicle);
            }
        }
        return inventory;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                inventory.add(vehicle);
            }
        }
        return inventory;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public Vehicle getVehicleByVin(int vin) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vin) {
                return vehicle;
            }
        }
        return null;
    }

}
