# 🚗 RentaByte - Car Rental System in Java

A simple console-based Car Rental System built in Java using **core Object-Oriented Programming (OOP)** concepts like **abstraction**, **inheritance**, **polymorphism**, **encapsulation**, and **aggregation**.

This project allows a user to view available cars, rent one for a number of days, return the car, and see the total rental cost. It's designed to be clean, modular, and easy to understand—perfect for academic submission or as a foundational Java OOP project.

---

## ✅ Features

- View available vehicles
- Rent a vehicle based on plate number
- Return the rented vehicle
- Calculate total rental cost based on number of days
- Simple menu-driven console interface
- Clean class structure using OOP principles

---

## 🧠 OOP Concepts Used

| Concept        | Where It's Used                     |
|----------------|-------------------------------------|
| **Abstraction**   | `Vehicle` class (abstract)          |
| **Inheritance**   | `Car` and `SUV` classes extending `Vehicle` |
| **Polymorphism**  | `calculateRentalCost()` method overridden |
| **Encapsulation** | All fields are private with getters/setters |
| **Aggregation**   | `Customer` has a `Vehicle` instance  |

---

## 💠 Technologies

- Java 8 or later
- No external libraries
- Console-based (no GUI)

---

## 📆 File Structure

```
RentaByte/
├── Main.java
├── Vehicle.java
├── Car.java
├── SUV.java
├── Customer.java
└── RentalService.java
```

---

## ▶️ How to Run

### 🧑‍💻 Prerequisites
- Java installed (JDK 8+)

### 📌 Steps
1. Clone the repo or download the files.
2. Open terminal in the project folder.
3. Compile all Java files:
   ```bash
   javac *.java
   ```
4. Run the application:
   ```bash
   java Main
   ```

---

## 💻 Sample Input/Output

### 👤 User Input (Example)

```
Enter your name: Riya

--- Car Rental Menu ---
1. View Available Vehicles
2. Rent a Vehicle
3. Return Vehicle
4. Exit
Choose an option: 1

Plate: KA01AB1234, Brand: Honda City, Available: true  
Plate: MH12CD5678, Brand: Hyundai Creta, Available: true  
Plate: DL09XY1122, Brand: Maruti Swift, Available: true  

Choose an option: 2  
Enter plate number to rent: KA01AB1234  
Enter number of days to rent: 3  
Vehicle rented successfully.

Choose an option: 3  
Returning vehicle: KA01AB1234  
Total cost for 3 day(s): ₹150.0  

Choose an option: 4  
Thank you for using the Car Rental System!
```

---

## 📈 Future Improvements (Optional)

- Add user registration/login
- GUI using Swing or JavaFX
- File or database-based persistence
- Admin panel to add/remove vehicles
- Rent multiple vehicles

---


## ✨ Author

**Jal Bafana**  
Second Year B.Tech CSE (Cyber Security)  
[GitHub](https://github.com/Jal-Bafana) • [LinkedIn](https://linkedin.com/in/yourprofile)

