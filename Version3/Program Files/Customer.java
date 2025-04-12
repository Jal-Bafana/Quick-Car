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
            System.out.println("Total cost for " + rentedDays + " day(s): ₹" + cost);
            rentedVehicle.setAvailable(true);
            rentedVehicle = null;
            rentedDays = 0;
        } else {
            System.out.println("You have no rented vehicle.");
        }
    }

    public boolean hasRentedVehicle() {
        return rentedVehicle != null;
    }
}
