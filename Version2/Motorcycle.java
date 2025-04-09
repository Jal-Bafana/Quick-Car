public class Motorcycle extends Vehicle {
    private String engineType;
    private boolean hasHelmet;
    private int engineCapacity;

    public Motorcycle(String vehicleId, String brand, String model, int year, String color, 
                      double dailyRate, String engineType, boolean hasHelmet, int engineCapacity) {
        super(vehicleId, brand, model, year, color, dailyRate);
        this.engineType = engineType;
        this.hasHelmet = hasHelmet;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Engine Type: " + engineType);
        System.out.println("Helmet Included: " + (hasHelmet ? "Yes" : "No"));
        System.out.println("Engine Capacity: " + engineCapacity + "cc");
    }

    // Getters for motorcycle-specific properties
    public String getEngineType() { return engineType; }
    public boolean hasHelmet() { return hasHelmet; }
    public int getEngineCapacity() { return engineCapacity; }
} 