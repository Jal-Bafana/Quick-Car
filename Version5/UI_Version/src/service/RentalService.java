package service;

import model.*;

import java.util.ArrayList;

public class RentalService {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Customer> customers;

    public RentalService() {
        vehicles = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public void registerCustomer(Customer c) {
        customers.add(c);
    }

    public ArrayList<Vehicle> getAvailableVehicles() {
        ArrayList<Vehicle> available = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.isAvailable()) available.add(v);
        }
        return available;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Vehicle findVehicleByPlate(String plate) {
        for (Vehicle v : vehicles) {
            if (v.getPlateNumber().equalsIgnoreCase(plate)) return v;
        }
        return null;
    }

    public Customer findCustomerByName(String name) {
        for (Customer c : customers) {
            if (c.getName().equalsIgnoreCase(name)) return c;
        }
        return null;
    }
}
