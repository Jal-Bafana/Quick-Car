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
            double cost = rentedVehicle.calculateRentalCost(rentedDays);
            System.out.println("Returning vehicle: " + rentedVehicle.getPlateNumber());
            System.out.println("Total cost for " + rentedDays + " day(s): Rs. " + cost);
            rentedVehicle.setAvailable(true);
            rentedVehicle = null;
            rentedDays = 0;
        } else {
            System.out.println("No rented vehicle to return.");
        }
    }

    public boolean hasRentedVehicle() {
        return rentedVehicle != null;
    }

    @Override
    public String toString() {
        return "Customer: " + name + (rentedVehicle != null ? " | Rented: " + rentedVehicle.getPlateNumber() : " | No active rental");
    }
}
