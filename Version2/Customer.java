public class Customer {
    private String customerId;
    private String name;
    private String contactNumber;
    private String email;
    private String licenseNumber;
    private int age;
    private boolean hasValidLicense;

    // Constructor
    public Customer(String customerId, String name, String contactNumber, String email, 
                   String licenseNumber, int age) {
        this.customerId = customerId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.licenseNumber = licenseNumber;
        this.age = age;
        this.hasValidLicense = validateLicense();
    }

    private boolean validateLicense() {
        // Basic validation - in real system, this would check with DMV database
        return licenseNumber != null && !licenseNumber.isEmpty() && age >= 18;
    }

    // Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getAge() {
        return age;
    }

    public boolean hasValidLicense() {
        return hasValidLicense;
    }

    // Method to display customer details
    public void displayCustomerDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Email: " + email);
        System.out.println("License Number: " + licenseNumber);
        System.out.println("Age: " + age);
        System.out.println("License Status: " + (hasValidLicense ? "Valid" : "Invalid"));
    }
} 