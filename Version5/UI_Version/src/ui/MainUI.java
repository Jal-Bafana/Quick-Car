package ui;

import model.*;
import service.RentalService;

import javax.swing.*;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainUI extends JFrame {
    private RentalService service;

    public MainUI(RentalService service) {
        this.service = service;
        setTitle("RentaByte - Car Rental Owner Dashboard");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();

        // Panel 1: Register Customer
        JPanel registerPanel = new JPanel(new FlowLayout());
        JTextField nameField = new JTextField(20);
        JButton regBtn = new JButton("Register");
        registerPanel.add(new JLabel("Customer Name:"));
        registerPanel.add(nameField);
        registerPanel.add(regBtn);

        regBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                service.registerCustomer(new Customer(name));
                JOptionPane.showMessageDialog(this, "Customer registered.");
                nameField.setText("");
            }
        });

        // Panel 2: Rent Vehicle
        JPanel rentPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField custRent = new JTextField();
        JComboBox<Vehicle> vehicleBox = new JComboBox<>();
        JTextField daysField = new JTextField();
        JButton rentBtn = new JButton("Rent Vehicle");

        rentPanel.add(new JLabel("Customer Name:"));
        rentPanel.add(custRent);
        rentPanel.add(new JLabel("Select Vehicle:"));
        rentPanel.add(vehicleBox);
        rentPanel.add(new JLabel("Days:"));
        rentPanel.add(daysField);
        rentPanel.add(new JLabel(""));
        rentPanel.add(rentBtn);

        rentBtn.addActionListener(e -> {
            Customer c = service.findCustomerByName(custRent.getText().trim());
            Vehicle v = (Vehicle) vehicleBox.getSelectedItem();
            int days;
            try {
                days = Integer.parseInt(daysField.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number of days.");
                return;
            }

            if (c != null && v != null && v.isAvailable()) {
                if (c.hasRentedVehicle()) {
                    JOptionPane.showMessageDialog(this, "Customer already has a vehicle.");
                } else {
                    c.rentVehicle(v, days);
                    JOptionPane.showMessageDialog(this, "Vehicle rented to " + c.getName());
                    refreshVehicles(vehicleBox);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Customer or vehicle not found.");
            }
        });

        // Panel 3: Return Vehicle
        JPanel returnPanel = new JPanel(new FlowLayout());
        JTextField custReturn = new JTextField(20);
        JButton returnBtn = new JButton("Return Vehicle");
        returnPanel.add(new JLabel("Customer Name:"));
        returnPanel.add(custReturn);
        returnPanel.add(returnBtn);

        returnBtn.addActionListener(e -> {
            Customer c = service.findCustomerByName(custReturn.getText().trim());
            if (c != null && c.hasRentedVehicle()) {
                double cost = c.getRentalCost();
                c.returnVehicle();
                JOptionPane.showMessageDialog(this, "Vehicle returned. Total: ₹" + cost);
                refreshVehicles(vehicleBox);
            } else {
                JOptionPane.showMessageDialog(this, "No vehicle rented or customer not found.");
            }
        });

        // Panel 4: View Customers
        JPanel viewPanel = new JPanel(new BorderLayout());
        JTextArea custList = new JTextArea();
        custList.setEditable(false);
        JButton refreshBtn = new JButton("Refresh");
        viewPanel.add(new JScrollPane(custList), BorderLayout.CENTER);
        viewPanel.add(refreshBtn, BorderLayout.SOUTH);

        refreshBtn.addActionListener((ActionEvent e) -> {
            StringBuilder sb = new StringBuilder();
            for (Customer c : service.getCustomers()) {
                sb.append(c).append("\n");
            }
            custList.setText(sb.toString());
        });

        tabs.add("Register", registerPanel);
        tabs.add("Rent", rentPanel);
        tabs.add("Return", returnPanel);
        tabs.add("Customers", viewPanel);

        add(tabs, BorderLayout.CENTER);
        refreshVehicles(vehicleBox);
    }

    private void refreshVehicles(JComboBox<Vehicle> box) {
        box.removeAllItems();
        for (Vehicle v : service.getAvailableVehicles()) {
            box.addItem(v);
        }
    }
}
