# 🚗 RentaByte - Car Rental Management System (Owner Version)

Welcome to **RentaByte**, a Java-based Car Rental Management System designed from the **owner's perspective**. This application allows the owner of a rental service to manage multiple customers, track who has rented or returned a vehicle, and view the status of the entire fleet in real time.

---

## 📋 Features

- 🔐 **Register Multiple Customers**
- 🚙 **View Available Vehicles**
- 🧾 **Assign/Rent Vehicles to Customers**
- ✅ **Return Vehicles & Calculate Rental Cost**
- 👥 **Track All Customers' Rental Status**
- 📦 **Support for Different Vehicle Types (Cars & SUVs)**

---

## 🏗️ Project Structure

```
car_rental_system/
├── Main.java              # Entry point and owner menu
├── Customer.java          # Represents customers and their rentals
├── Vehicle.java           # Abstract class for vehicle behavior
├── Car.java               # Concrete Car vehicle type
├── SUV.java               # Concrete SUV vehicle type
└── RentalService.java     # Manages fleet and customer records
```

---

## 💠 How to Compile & Run

1. **Open terminal/command prompt** in the project directory.
2. **Compile all Java files**:
   ```bash
   javac *.java
   ```
3. **Run the program**:
   ```bash
   java Main
   ```

---

## 🥪 Sample Usage

```text
--- Owner Dashboard ---
1. Register New Customer
2. View Available Vehicles
3. Rent a Vehicle to Customer
4. Return Vehicle from Customer
5. View All Customers
6. Exit

Choose an option: 1
Enter customer name: Alice
Customer registered.

Choose an option: 2
Plate: KA01AB1234, Brand: Honda City, Available: true
...

Choose an option: 3
Enter customer name: Alice
Enter plate number to rent: KA01AB1234
Enter number of days: 5
Vehicle rented to Alice.

Choose an option: 5
Customer: Alice | Rented: KA01AB1234
```
