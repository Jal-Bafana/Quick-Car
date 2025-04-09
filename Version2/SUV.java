public class SUV extends Vehicle {
    private int seatingCapacity;
    private boolean hasFourWheelDrive;
    private double cargoSpace;

    public SUV(String vehicleId, String brand, String model, int year, String color, 
               double dailyRate, int seatingCapacity, boolean hasFourWheelDrive, double cargoSpace) {
        super(vehicleId, brand, model, year, color, dailyRate);
        this.seatingCapacity = seatingCapacity;
        this.hasFourWheelDrive = hasFourWheelDrive;
        this.cargoSpace = cargoSpace;
    }

    @Override
    public String getVehicleType() {
        return "SUV";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Seating Capacity: " + seatingCapacity);
        System.out.println("Four Wheel Drive: " + (hasFourWheelDrive ? "Yes" : "No"));
        System.out.println("Cargo Space: " + cargoSpace + " cubic feet");
    }

    // Getters for SUV-specific properties
    public int getSeatingCapacity() { return seatingCapacity; }
    public boolean hasFourWheelDrive() { return hasFourWheelDrive; }
    public double getCargoSpace() { return cargoSpace; }
} 