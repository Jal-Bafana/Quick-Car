public abstract class Vehicle implements Rentable {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected int year;
    protected String color;
    protected double dailyRate;
    protected boolean isAvailable;

    public Vehicle(String vehicleId, String brand, String model, int year, String color, double dailyRate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Abstract method to be implemented by subclasses
    public abstract String getVehicleType();

    // Common display method
    @Override
    public void displayDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Type: " + getVehicleType());
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Daily Rate: $" + dailyRate);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Rented"));
    }

    // Getters
    public String getVehicleId() { return vehicleId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getColor() { return color; }
    public double getDailyRate() { return dailyRate; }
} 