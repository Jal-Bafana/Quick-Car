public abstract class Vehicle {
    private String plateNumber;
    private String brand;
    private boolean isAvailable;

    public Vehicle(String plateNumber, String brand) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.isAvailable = true;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public abstract double calculateRentalCost(int days);

    public void displayInfo() {
        System.out.println("Plate: " + plateNumber + ", Brand: " + brand + ", Available: " + isAvailable);
    }
}
