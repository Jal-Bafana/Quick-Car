import java.util.ArrayList;

public class RentalService {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Customer> customers;

    public RentalService() {
        vehicles = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public void registerCustomer(Customer c) {
        customers.add(c);
    }

    public Vehicle findVehicleByPlate(String plate) {
        for (Vehicle v : vehicles) {
            if (v.getPlateNumber().equalsIgnoreCase(plate) && v.isAvailable()) {
                return v;
            }
        }
        return null;
    }

    public void listAvailableVehicles() {
        boolean found = false;
        for (Vehicle v : vehicles) {
            if (v.isAvailable()) {
                v.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available vehicles at the moment.");
        }
    }

    public void listAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers registered.");
        } else {
            for (Customer c : customers) {
                System.out.println(c);
            }
        }
    }

    public Customer findCustomerByName(String name) {
        for (Customer c : customers) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
}
