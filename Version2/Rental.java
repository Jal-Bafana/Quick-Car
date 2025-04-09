import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental {
    private String rentalId;
    private Vehicle vehicle;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCost;
    private boolean isActive;
    private double depositAmount;
    private String rentalStatus;

    // Constructor
    public Rental(String rentalId, Vehicle vehicle, Customer customer, 
                  LocalDate startDate, LocalDate endDate, double depositAmount) {
        this.rentalId = rentalId;
        this.vehicle = vehicle;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.depositAmount = depositAmount;
        this.isActive = true;
        this.rentalStatus = "Active";
        calculateTotalCost();
    }

    private void calculateTotalCost() {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        this.totalCost = vehicle.calculateRentalCost((int)days);
    }

    public void returnVehicle() {
        if (isActive) {
            this.isActive = false;
            this.rentalStatus = "Completed";
            this.vehicle.setAvailable(true);
        }
    }

    // Method to display rental details
    public void displayRentalDetails() {
        System.out.println("\nRental Details:");
        System.out.println("Rental ID: " + rentalId);
        System.out.println("Status: " + rentalStatus);
        System.out.println("\nVehicle Details:");
        vehicle.displayDetails();
        System.out.println("\nCustomer Details:");
        customer.displayCustomerDetails();
        System.out.println("\nRental Period:");
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("Deposit Amount: $" + depositAmount);
    }

    // Getters
    public String getRentalId() { return rentalId; }
    public Vehicle getVehicle() { return vehicle; }
    public Customer getCustomer() { return customer; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public double getTotalCost() { return totalCost; }
    public boolean isActive() { return isActive; }
    public double getDepositAmount() { return depositAmount; }
    public String getRentalStatus() { return rentalStatus; }
} 