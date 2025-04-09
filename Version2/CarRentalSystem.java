import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Vehicle> vehicles;
    private List<Customer> customers;
    private List<Rental> rentals;
    private Scanner scanner;

    public CarRentalSystem() {
        this.vehicles = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    rentVehicle();
                    break;
                case 4:
                    returnVehicle();
                    break;
                case 5:
                    displayAvailableVehicles();
                    break;
                case 6:
                    displayAllRentals();
                    break;
                case 7:
                    displayAllCustomers();
                    break;
                case 8:
                    running = false;
                    System.out.println("Thank you for using the Car Rental System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n===== Car Rental System Menu =====");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Add Customer");
        System.out.println("3. Rent Vehicle");
        System.out.println("4. Return Vehicle");
        System.out.println("5. Display Available Vehicles");
        System.out.println("6. Display All Rentals");
        System.out.println("7. Display All Customers");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addVehicle() {
        System.out.println("\n===== Add Vehicle =====");
        System.out.println("Select vehicle type:");
        System.out.println("1. Car");
        System.out.println("2. SUV");
        System.out.println("3. Motorcycle");
        System.out.print("Enter choice: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Vehicle ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Color: ");
        String color = scanner.nextLine();
        System.out.print("Enter Daily Rate: ");
        double rate = scanner.nextDouble();
        scanner.nextLine();

        switch (type) {
            case 1:
                System.out.print("Enter Number of Seats: ");
                int seats = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Transmission Type: ");
                String transmission = scanner.nextLine();
                System.out.print("Has Air Conditioning? (true/false): ");
                boolean ac = scanner.nextBoolean();
                scanner.nextLine();
                vehicles.add(new Car(id, brand, model, year, color, rate, seats, transmission, ac));
                break;
            case 2:
                System.out.print("Enter Seating Capacity: ");
                int capacity = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Has Four Wheel Drive? (true/false): ");
                boolean fwd = scanner.nextBoolean();
                scanner.nextLine();
                System.out.print("Enter Cargo Space (cubic feet): ");
                double cargo = scanner.nextDouble();
                scanner.nextLine();
                vehicles.add(new SUV(id, brand, model, year, color, rate, capacity, fwd, cargo));
                break;
            case 3:
                System.out.print("Enter Engine Type: ");
                String engine = scanner.nextLine();
                System.out.print("Has Helmet? (true/false): ");
                boolean helmet = scanner.nextBoolean();
                scanner.nextLine();
                System.out.print("Enter Engine Capacity (cc): ");
                int cc = scanner.nextInt();
                scanner.nextLine();
                vehicles.add(new Motorcycle(id, brand, model, year, color, rate, engine, helmet, cc));
                break;
        }
        System.out.println("Vehicle added successfully!");
    }

    private void addCustomer() {
        System.out.println("\n===== Add Customer =====");
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter License Number: ");
        String license = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        customers.add(new Customer(id, name, contact, email, license, age));
        System.out.println("Customer added successfully!");
    }

    private void rentVehicle() {
        System.out.println("\n===== Rent Vehicle =====");
        displayAvailableVehicles();
        System.out.print("Enter Vehicle ID: ");
        String vehicleId = scanner.nextLine();
        Vehicle vehicle = findVehicleById(vehicleId);

        if (vehicle == null || !vehicle.isAvailable()) {
            System.out.println("Invalid or unavailable vehicle!");
            return;
        }

        displayAllCustomers();
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        Customer customer = findCustomerById(customerId);

        if (customer == null || !customer.hasValidLicense()) {
            System.out.println("Invalid customer or invalid license!");
            return;
        }

        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter End Date (YYYY-MM-DD): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter Deposit Amount: ");
        double deposit = scanner.nextDouble();
        scanner.nextLine();

        String rentalId = "R" + System.currentTimeMillis();
        Rental rental = new Rental(rentalId, vehicle, customer, startDate, endDate, deposit);
        rentals.add(rental);
        vehicle.setAvailable(false);
        System.out.println("Vehicle rented successfully!");
        rental.displayRentalDetails();
    }

    private void returnVehicle() {
        System.out.println("\n===== Return Vehicle =====");
        System.out.print("Enter Rental ID: ");
        String rentalId = scanner.nextLine();
        Rental rental = findRentalById(rentalId);

        if (rental != null && rental.isActive()) {
            rental.returnVehicle();
            System.out.println("Vehicle returned successfully!");
        } else {
            System.out.println("Invalid or inactive rental!");
        }
    }

    private void displayAvailableVehicles() {
        System.out.println("\n===== Available Vehicles =====");
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                vehicle.displayDetails();
                System.out.println("-------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles available at the moment.");
        }
    }

    private void displayAllRentals() {
        System.out.println("\n===== All Rentals =====");
        if (rentals.isEmpty()) {
            System.out.println("No rentals found.");
            return;
        }
        for (Rental rental : rentals) {
            rental.displayRentalDetails();
            System.out.println("-------------------");
        }
    }

    private void displayAllCustomers() {
        System.out.println("\n===== All Customers =====");
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer customer : customers) {
            customer.displayCustomerDetails();
            System.out.println("-------------------");
        }
    }

    private Vehicle findVehicleById(String id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(id)) {
                return vehicle;
            }
        }
        return null;
    }

    private Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    private Rental findRentalById(String id) {
        for (Rental rental : rentals) {
            if (rental.getRentalId().equals(id)) {
                return rental;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();
        system.start();
    }
} 