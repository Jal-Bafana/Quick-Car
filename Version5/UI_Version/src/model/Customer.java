package model;

public class Customer {
    private String name;
    private Vehicle rentedVehicle;
    private int rentedDays;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Vehicle getRentedVehicle() {
        return rentedVehicle;
    }

    public void rentVehicle(Vehicle vehicle, int days) {
        this.rentedVehicle = vehicle;
        this.rentedDays = days;
        vehicle.setAvailable(false);
    }

    public void returnVehicle() {
        if (rentedVehicle != null) {
            rentedVehicle.setAvailable(true);
            rentedVehicle = null;
            rentedDays = 0;
        }
    }

    public boolean hasRentedVehicle() {
        return rentedVehicle != null;
    }

    public double getRentalCost() {
        return rentedVehicle.calculateRentalCost(rentedDays);
    }

    @Override
    public String toString() {
        return name + (hasRentedVehicle() ? " | Rented: " + rentedVehicle.getPlateNumber() : " | No Active Rental");
    }
}
