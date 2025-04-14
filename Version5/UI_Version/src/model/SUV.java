package model;

public class SUV extends Vehicle {
    public SUV(String plateNumber, String brand) {
        super(plateNumber, brand);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * 80;
    }
}
