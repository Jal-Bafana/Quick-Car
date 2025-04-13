import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

class Vehicle {
    protected String plateNumber;
    protected String model;
    protected boolean available = true;

    public Vehicle(String plateNumber, String model) {
        this.plateNumber = plateNumber;
        this.model = model;
    }

    public String getPlateNumber() { return plateNumber; }
    public String getModel() { return model; }
    public boolean isAvailable() { return available; }

    public void rent() { available = false; }
    public void returnVehicle() { available = true; }

    public String getType() { return "Generic"; }
    public int getRatePerDay() { return 1000; }
}

class Car extends Vehicle {
    public Car(String plateNumber, String model) {
        super(plateNumber, model);
    }

    public String getType() { return "Car"; }
    public int getRatePerDay() { return 1200; }
}

class SUV extends Vehicle {
    public SUV(String plateNumber, String model) {
        super(plateNumber, model);
    }

    public String getType() { return "SUV"; }
    public int getRatePerDay() { return 1500; }
}

class Customer {
    private String name;
    private Vehicle rentedVehicle;
    private int rentalDays;

    public Customer(String name) {
        this.name = name;
    }

    public boolean hasRentedVehicle() {
        return rentedVehicle != null;
    }

    public void rentVehicle(Vehicle vehicle, int days) {
        this.rentedVehicle = vehicle;
        this.rentalDays = days;
        vehicle.rent();
    }

    public String returnVehicle() {
        if (rentedVehicle != null) {
            rentedVehicle.returnVehicle();
            int cost = rentalDays * rentedVehicle.getRatePerDay();
            String message = "Returned " + rentedVehicle.getModel() + ". Total cost: ₹" + cost;
            rentedVehicle = null;
            rentalDays = 0;
            return message;
        }
        return "No vehicle to return.";
    }

    public Vehicle getRentedVehicle() {
        return rentedVehicle;
    }
}

public class RentaByteUI extends JFrame {
    private List<Vehicle> vehicles = new ArrayList<>();
    private Customer customer;
    private JTable vehicleTable;
    private DefaultTableModel tableModel;
    private JTextField nameField;

    public RentaByteUI() {
        setTitle("RentaByte - Car Rental System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        initFlatLaf();
        initVehicles();
        initUI();
    }

    private void initFlatLaf() {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initVehicles() {
        vehicles.add(new Car("KA01AB1234", "Honda City"));
        vehicles.add(new SUV("MH12CD5678", "Hyundai Creta"));
        vehicles.add(new Car("DL09XY1122", "Maruti Swift"));
    }

    private void initUI() {
        JPanel namePanel = new JPanel(new FlowLayout());
        namePanel.add(new JLabel("Enter your name:"));
        nameField = new JTextField(20);
        namePanel.add(nameField);
        JButton startBtn = new JButton("Start");
        namePanel.add(startBtn);

        add(namePanel, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel viewPanel = new JPanel(new BorderLayout());
        JPanel rentPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JPanel returnPanel = new JPanel(new FlowLayout());

        // Table to show vehicles
        String[] columns = {"Plate", "Model", "Type", "Available"};
        tableModel = new DefaultTableModel(columns, 0);
        vehicleTable = new JTable(tableModel);
        refreshVehicleTable();

        viewPanel.add(new JScrollPane(vehicleTable), BorderLayout.CENTER);

        JTextField rentPlate = new JTextField();
        JTextField rentDays = new JTextField();
        JButton rentBtn = new JButton("Rent");

        rentPanel.add(new JLabel("Plate Number:"));
        rentPanel.add(rentPlate);
        rentPanel.add(new JLabel("Number of Days:"));
        rentPanel.add(rentDays);
        rentPanel.add(new JLabel(""));
        rentPanel.add(rentBtn);

        JButton returnBtn = new JButton("Return Vehicle");
        returnPanel.add(returnBtn);

        tabbedPane.addTab("Available Vehicles", viewPanel);
        tabbedPane.addTab("Rent Vehicle", rentPanel);
        tabbedPane.addTab("Return Vehicle", returnPanel);

        add(tabbedPane, BorderLayout.CENTER);

        startBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                customer = new Customer(name);
                JOptionPane.showMessageDialog(this, "Welcome, " + name + "!");
                tabbedPane.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a name.");
            }
        });

        rentBtn.addActionListener(e -> {
            if (customer == null) return;

            if (customer.hasRentedVehicle()) {
                JOptionPane.showMessageDialog(this, "You already have a rented vehicle.");
                return;
            }

            String plate = rentPlate.getText().trim();
            int days;

            try {
                days = Integer.parseInt(rentDays.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number of days.");
                return;
            }

            Vehicle vehicle = findVehicleByPlate(plate);
            if (vehicle != null && vehicle.isAvailable()) {
                customer.rentVehicle(vehicle, days);
                JOptionPane.showMessageDialog(this, "Vehicle rented successfully!");
                refreshVehicleTable();
            } else {
                JOptionPane.showMessageDialog(this, "Vehicle not available.");
            }
        });

        returnBtn.addActionListener(e -> {
            if (customer != null && customer.hasRentedVehicle()) {
                String msg = customer.returnVehicle();
                JOptionPane.showMessageDialog(this, msg);
                refreshVehicleTable();
            } else {
                JOptionPane.showMessageDialog(this, "No vehicle to return.");
            }
        });

        tabbedPane.setEnabled(false); // Disable tabs initially
    }

    private void refreshVehicleTable() {
        tableModel.setRowCount(0);
        for (Vehicle v : vehicles) {
            tableModel.addRow(new Object[]{
                    v.getPlateNumber(),
                    v.getModel(),
                    v.getType(),
                    v.isAvailable() ? "Yes" : "No"
            });
        }
    }

    private Vehicle findVehicleByPlate(String plate) {
        for (Vehicle v : vehicles) {
            if (v.getPlateNumber().equalsIgnoreCase(plate)) {
                return v;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RentaByteUI app = new RentaByteUI();
            app.setVisible(true);
        });
    }
}
