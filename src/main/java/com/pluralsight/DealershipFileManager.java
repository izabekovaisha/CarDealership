package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    private static ArrayList<Dealership> dealership = new ArrayList<>();
    private static String filename = "dealership.csv";


    public Dealership getDealership(String filename) {
        List<Dealership>  dealership = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;
            String line2 = null;

            if ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\\|");

                    if (parts.length == 3) {
                        String name = parts[0].trim();
                        String address = parts[1].trim();
                        String phone = parts[2].trim();

                    }
                }

            while ((line2 = bufferedReader.readLine()) != null) {
                String[] parts = line2.split("\\|");

                if (parts.length == 8) {
                    int vin = Integer.parseInt(parts[0].trim());;
                    int year = Integer.parseInt(parts[1].trim());;
                    String make = parts[2].trim();;
                    String model = parts[3].trim();;
                    String vehicleType = parts[4].trim();;
                    String color = parts[5].trim();;
                    int odometer = Integer.parseInt(parts[6].trim());;
                    double price = Double.parseDouble(parts[7].trim());

            inventory.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price)));
                }
            }
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }



    public saveDealership()
}
