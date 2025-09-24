// File: Car.java
public class Car extends Vehicle {
    // Car-specific fields
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    // Default constructor
    public Car() {
        super(); // Call parent default constructor
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    // Parameterized constructor
    public Car(String brand, String model, int year, String engineType,
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType); // Call parent parameterized constructor
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    // Override start()
    @Override
    public void start() {
        super.start(); // Call parent start first
        System.out.println("Car-specific startup sequence initiated");
    }

    // Override displaySpecs()
    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("=== Car Specifications ===");
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Transmission: " + transmissionType);
    }

    // Car-specific methods
    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    // Main method for testing
    public static void main(String[] args) {
        // 1. Create Car using default constructor
        System.out.println("----- Default Constructor Test -----");
        Car car1 = new Car();
        car1.displaySpecs();

        // 2. Create Car using parameterized constructor
        System.out.println("\n----- Parameterized Constructor Test -----");
        Car car2 = new Car("Toyota", "Corolla", 2022, "Hybrid",
                           4, "Petrol", "Automatic");
        car2.displaySpecs();

        // Test inheritance of fields and methods
        System.out.println("\n----- Inheritance Test -----");
        System.out.println("Car2 Info: " + car2.getVehicleInfo());
        car2.start();
        car2.stop();

        // Test overridden methods
        System.out.println("\n----- Overridden Methods Test -----");
        car2.start(); // Will run Vehicle + Car-specific sequence

        // Test car-specific methods
        System.out.println("\n----- Car-Specific Methods Test -----");
        car2.openTrunk();
        car2.playRadio();

        // Demonstrating super keyword in start() + constructor chaining
        System.out.println("\n----- Super Keyword & Polymorphism Test -----");
        Vehicle v = new Car("Honda", "Civic", 2023, "Petrol", 4, "Diesel", "Manual");
        v.displaySpecs(); // Polymorphic behavior
        v.start();        // Calls Car's overridden start()
    }
}

