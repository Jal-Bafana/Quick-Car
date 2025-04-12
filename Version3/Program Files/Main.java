import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RentalService service = new RentalService();

        // Add some sample vehicles
        service.addVehicle(new Car("KA01AB1234", "Honda City"));
        service.addVehicle(new SUV("MH12CD5678", "Hyundai Creta"));
        service.addVehicle(new Car("DL09XY1122", "Maruti Swift"));

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        Customer customer = new Customer(name);

        int choice;
        do {
            System.out.println("\n--- Car Rental Menu ---");
            System.out.println("1. View Available Vehicles");
            System.out.println("2. Rent a Vehicle");
            System.out.println("3. Return Vehicle");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    service.listAvailableVehicles();
                    break;

                case 2:
                    if (customer.hasRentedVehicle()) {
                        System.out.println("You already have a rented vehicle. Return it first.");
                        break;
                    }
                    service.listAvailableVehicles();
                    System.out.print("Enter plate number to rent: ");
                    String plate = sc.nextLine();
                    Vehicle selected = service.findVehicleByPlate(plate);
                    if (selected != null) {
                        System.out.print("Enter number of days to rent: ");
                        int days = sc.nextInt();
                        customer.rentVehicle(selected, days);
                        System.out.println("Vehicle rented successfully.");
                    } else {
                        System.out.println("Vehicle not found or not available.");
                    }
                    break;

                case 3:
                    customer.returnVehicle();
                    break;

                case 4:
                    System.out.println("Thank you for using the Car Rental System!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
