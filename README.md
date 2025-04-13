# 🚗 RentaByte - Car Rental System (Modern UI Version [Version4])

**RentaByte** is a sleek and modern Java-based Car Rental System featuring a stylish user interface built using **Java Swing** and **FlatLaf**. This version improves usability and presentation for end-users while maintaining a strong foundation in Object-Oriented Programming (OOP) principles.

## ✅ Features

- View available vehicles
- Rent a vehicle by selecting from a table
- Return the rented vehicle
- Calculate total rental cost based on number of days
- Interactive modern GUI with FlatLaf theme
- User-friendly and intuitive layout

## 🧠 OOP Concepts Used

| Concept           | Where It's Used                             |
| ----------------- | ------------------------------------------- |
| **Abstraction**   | `Vehicle` class (abstract)                  |
| **Inheritance**   | `Car` and `SUV` classes extending `Vehicle` |
| **Polymorphism**  | `calculateRentalCost()` method overridden   |
| **Encapsulation** | All fields are private with getters/setters |
| **Aggregation**   | `Customer` has a `Vehicle` instance         |

## 💠 Technologies Used

- Java 8 or later
- Java Swing
- FlatLaf Look and Feel (for modern UI)

## 📁 Project Structure

RentaByteModernUI/
├── lib/
│   └── flatlaf-3.2.jar
├── src/
│   └── RentaByteUI.java
└── README.md    


## ▶️ How to Run

### 🧑‍💻 Prerequisites

- Java installed (JDK 8+)
- FlatLaf `.jar` downloaded and placed inside `lib/`

### 📌 Steps

1. Clone the repo or download the files.
2. Download FlatLaf from [here](https://repo1.maven.org/maven2/com/formdev/flatlaf/3.2/flatlaf-3.2.jar).
3. Place the `.jar` file in the `lib` folder.
4. Open terminal in the project root.
5. Compile the project:
```bash
javac -cp lib/flatlaf-3.2.jar src/RentaByteUI.java
```
6. Run the program:
```bash
java -cp "lib/flatlaf-3.2.jar;src" RentaByteUI
```
💡 On macOS/Linux, use : instead of ;

## 💻 Sample Walkthrough

- App launches with a prompt to enter your name.
- You are greeted with a dashboard with three options:
  - View Available Vehicles (Table View)
  - Rent Selected Vehicle (Prompt for Days)
  - Return Vehicle (Shows Rental Cost)

**Example:**
```bash
Name: Jal Vehicle rented: Honda City (3 days) Returned: ₹150.0 charged.
```
All handled via GUI, no console input required.

---

## 🌱 Future Additions

- Add database persistence (SQLite/MySQL)
- Admin panel for managing cars
- Login system with user profiles
- Receipt generation (PDF)
- Switchable themes and dark mode

---

## ✨ Author

**Jal Bafana**  
Second Year B.Tech CSE (Cyber Security)  
[GitHub](https://github.com/Jal-Bafana)
