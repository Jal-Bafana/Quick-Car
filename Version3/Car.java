public class Car extends Vehicle {
    public Car(String plateNumber, String brand) {
        super(plateNumber, brand);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * 50; // ₹50/day
    }
}
