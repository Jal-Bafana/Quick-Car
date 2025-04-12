import java.util.ArrayList;

public class RentalService {
    private ArrayList<Vehicle> vehicles;

    public RentalService() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
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

    public Vehicle findVehicleByPlate(String plate) {
        for (Vehicle v : vehicles) {
            if (v.getPlateNumber().equalsIgnoreCase(plate) && v.isAvailable()) {
                return v;
            }
        }
        return null;
    }
}
