import java.util.*;

class Car {
    private String model;
    private String plateNumber;
    private boolean isRented;
    private double rentalPricePerDay;

    public Car(String model, String plateNumber, double rentalPricePerDay) {
        this.model = model;
        this.plateNumber = plateNumber;
        this.isRented = false;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public String getModel() { return model; }
    public String getPlateNumber() { return plateNumber; }
    public boolean isRented() { return isRented; }
    public double getRentalPricePerDay() { return rentalPricePerDay; }
    
    public void rentCar() { isRented = true; }
    public void returnCar() { isRented = false; }
}

class Customer {
    private String name;
    private String contactNumber;
    private String rentedCarPlate;
    private Date startDate;
    private Date endDate;

    public Customer(String name, String contactNumber, String rentedCarPlate, Date startDate, Date endDate) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.rentedCarPlate = rentedCarPlate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() { return name; }
    public String getContactNumber() { return contactNumber; }
    public String getRentedCarPlate() { return rentedCarPlate; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
}

class CarRentalSystem {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public void addCar(String model, String plateNumber, double rentalPricePerDay) {
        cars.add(new Car(model, plateNumber, rentalPricePerDay));
    }

    public void rentCar(String name, String contactNumber, String plateNumber, Date startDate, Date endDate) {
        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber) && !car.isRented()) {
                car.rentCar();
                customers.add(new Customer(name, contactNumber, plateNumber, startDate, endDate));
                System.out.println("Car rented successfully to " + name);
                return;
            }
        }
        System.out.println("Car not available for rent.");
    }

    public void returnCar(String plateNumber) {
        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber) && car.isRented()) {
                car.returnCar();
                customers.removeIf(c -> c.getRentedCarPlate().equals(plateNumber));
                System.out.println("Car returned successfully.");
                return;
            }
        }
        System.out.println("Invalid return request.");
    }

    public void displayAvailableCars() {
        System.out.println("Available Cars:");
        for (Car car : cars) {
            if (!car.isRented()) {
                System.out.println(car.getModel() + " - " + car.getPlateNumber() + " ($" + car.getRentalPricePerDay() + " per day)");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarRentalSystem system = new CarRentalSystem();

        system.addCar("Toyota Corolla", "ABC123", 30.0);
        system.addCar("Honda Civic", "XYZ789", 40.0);
        system.addCar("Ford Focus", "LMN456", 35.0);
        system.addCar("BMW X5", "BMW555", 100.0);
        system.addCar("Tesla Model S", "TES999", 120.0);
        system.addCar("Audi A6", "AUD666", 90.0);
        
        while (true) {
            System.out.println("\nCar Rental System");
            System.out.println("1. Display Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    system.displayAvailableCars();
                    break;
                case 2:
                    System.out.print("Enter Your Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Plate Number to Rent: ");
                    String rentPlate = scanner.nextLine();
                    System.out.print("Enter Start Date (yyyy-mm-dd): ");
                    Date startDate = new Date();
                    System.out.print("Enter End Date (yyyy-mm-dd): ");
                    Date endDate = new Date();
                    system.rentCar(name, contact, rentPlate, startDate, endDate);
                    break;
                case 3:
                    System.out.print("Enter Plate Number to Return: ");
                    String returnPlate = scanner.nextLine();
                    system.returnCar(returnPlate);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
