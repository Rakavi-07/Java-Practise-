// File: Vehicle.java
import java.util.Random;

public class Vehicle {
    // Protected fields for inheritance
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    // Private fields with getter/setter
    private String registrationNumber;
    private boolean isRunning;

    // Default constructor
    public Vehicle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.engineType = "Unknown";
        this.registrationNumber = "REG" + new Random().nextInt(10000);
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    // Parameterized constructor
    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = "REG" + new Random().nextInt(10000);
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    // Vehicle operations
    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year +
               ", Engine: " + engineType + ", Reg#: " + registrationNumber +
               ", Running: " + isRunning;
    }

    public void displaySpecs() {
        System.out.println("=== Vehicle Specifications ===");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine Type: " + engineType);
    }

    // Getter/Setter for private fields
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
