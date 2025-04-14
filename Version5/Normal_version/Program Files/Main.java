import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RentalService service = new RentalService();

        // Add vehicles
        service.addVehicle(new Car("KA01AB1234", "Honda City"));
        service.addVehicle(new SUV("MH12CD5678", "Hyundai Creta"));
        service.addVehicle(new Car("DL09XY1122", "Maruti Swift"));

        int choice;
        do {
            System.out.println("\n--- Owner Dashboard ---");
            System.out.println("1. Register New Customer");
            System.out.println("2. View Available Vehicles");
            System.out.println("3. Rent a Vehicle to Customer");
            System.out.println("4. Return Vehicle from Customer");
            System.out.println("5. View All Customers");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String cname = sc.nextLine();
                    Customer newCustomer = new Customer(cname);
                    service.registerCustomer(newCustomer);
                    System.out.println("Customer registered.");
                    break;

                case 2:
                    service.listAvailableVehicles();
                    break;

                case 3:
                    System.out.print("Enter customer name: ");
                    cname = sc.nextLine();
                    Customer rentingCustomer = service.findCustomerByName(cname);
                    if (rentingCustomer == null) {
                        System.out.println("Customer not found.");
                        break;
                    }
                    if (rentingCustomer.hasRentedVehicle()) {
                        System.out.println("Customer already has a rented vehicle.");
                        break;
                    }
                    service.listAvailableVehicles();
                    System.out.print("Enter plate number to rent: ");
                    String plate = sc.nextLine();
                    Vehicle toRent = service.findVehicleByPlate(plate);
                    if (toRent != null) {
                        System.out.print("Enter number of days: ");
                        int days = sc.nextInt();
                        rentingCustomer.rentVehicle(toRent, days);
                        System.out.println("Vehicle rented to " + cname);
                    } else {
                        System.out.println("Vehicle not found or unavailable.");
                    }
                    break;

                case 4:
                    System.out.print("Enter customer name: ");
                    cname = sc.nextLine();
                    Customer returningCustomer = service.findCustomerByName(cname);
                    if (returningCustomer == null) {
                        System.out.println("Customer not found.");
                        break;
                    }
                    returningCustomer.returnVehicle();
                    break;

                case 5:
                    service.listAllCustomers();
                    break;

                case 6:
                    System.out.println("Exiting Owner Dashboard...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 6);

        sc.close();
    }
}

