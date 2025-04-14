# RentaByte - Java Swing GUI Car Rental System 🏎️

A modern, Java-based car rental management system with a graphical user interface using **Swing** and **FlatLaf**. The project allows vehicle rental, returns, customer management, and more. Designed for vehicle rental business owners to track customers and rentals efficiently.

[![GitHub Repo](https://img.shields.io/badge/GitHub-RentaByte-blue?logo=github)](https://github.com/Jal-Bafana/RentaByte/tree/main/Version5/UI_Version)

---

## 📊 Features

- Add and manage vehicles (Cars and SUVs)
- Register and manage customers
- Rent and return vehicles
- Display total rental cost
- View available vehicles and all registered customers
- Modern UI with **FlatLaf** (IntelliJ theme)

---

## 📂 Project Structure

```
rentabyte/
├── lib/
│   └── flatlaf-3.2.jar              # FlatLaf look-and-feel library
├── src/
│   ├── model/
│   │   ├── Vehicle.java
│   │   ├── Car.java
│   │   ├── SUV.java
│   │   └── Customer.java
│   ├── service/
│   │   └── RentalService.java
│   └── ui/
│       └── MainUI.java              # Java Swing GUI entry
├── out/                             # Compiled classes
├── Main.java                        # Launches the GUI
└── README.md
```

---

## 🔧 How to Run

### 1. Clone the Repository
```bash
git clone https://github.com/Jal-Bafana/RentaByte.git
cd RentaByte/Version5/UI_Version
```

### 2. Download FlatLaf
Download the latest [FlatLaf JAR](https://www.formdev.com/flatlaf/) and place it in the `lib/` folder.

### 3. Compile the Code (Windows Example)
```bash
javac -cp "lib\flatlaf-3.2.jar" -d out src\model\*.java src\service\*.java src\ui\*.java Main.java
```

### 4. Run the App
```bash
java -cp "out;lib\flatlaf-3.2.jar" Main
```

---

## 🚀 Future Enhancements
- Database integration (MySQL/SQLite)
- Login system for multiple admins
- Date-based rental period tracking
- Export customer reports

---

## ✍️ Author
**Jal Bafana**  
[GitHub](https://github.com/Jal-Bafana)

---

Enjoy managing your rentals with ease! 🚗
