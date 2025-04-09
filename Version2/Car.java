public class Car extends Vehicle {
    private int numberOfSeats;
    private String transmissionType;
    private boolean hasAirConditioning;

    public Car(String vehicleId, String brand, String model, int year, String color, 
               double dailyRate, int numberOfSeats, String transmissionType, boolean hasAirConditioning) {
        super(vehicleId, brand, model, year, color, dailyRate);
        this.numberOfSeats = numberOfSeats;
        this.transmissionType = transmissionType;
        this.hasAirConditioning = hasAirConditioning;
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Seats: " + numberOfSeats);
        System.out.println("Transmission: " + transmissionType);
        System.out.println("Air Conditioning: " + (hasAirConditioning ? "Yes" : "No"));
    }

    // Getters for car-specific properties
    public int getNumberOfSeats() { return numberOfSeats; }
    public String getTransmissionType() { return transmissionType; }
    public boolean hasAirConditioning() { return hasAirConditioning; }
} 