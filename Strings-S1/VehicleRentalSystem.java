class Vehicle {
    // Instance variables
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    private int totalRentedDays; // rental history (instance-level)

    // Static variables
    private static int vehicleCounter = 0;
    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static int rentalDays = 0; // total rental days across all vehicles
    private static String companyName = "Default Rentals";

    // Constructor
    public Vehicle(String brand, String model, double rentPerDay) {
        this.vehicleId = generateVehicleId();
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        this.totalRentedDays = 0;

        totalVehicles++;
    }

    // Static method to generate unique vehicle IDs
    private static String generateVehicleId() {
        vehicleCounter++;
        return String.format("V%03d", vehicleCounter); // V001, V002, ...
    }

    // Method to calculate rent and update static revenue
    private double calculateRent(int days) {
        double amount = days * rentPerDay;
        totalRevenue += amount;
        rentalDays += days;
        totalRentedDays += days;
        return amount;
    }

    // Rent vehicle
    public void rentVehicle(int days) {
        if (isAvailable) {
            double amount = calculateRent(days);
            isAvailable = false;
            System.out.println("Vehicle " + vehicleId + " rented for " + days +
                               " days. Rent: " + amount);
        } else {
            System.out.println("Vehicle " + vehicleId + " is not available!");
        }
    }

    // Return vehicle
    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Vehicle " + vehicleId + " has been returned.");
        } else {
            System.out.println("Vehicle " + vehicleId + " was not rented.");
        }
    }

    // Display vehicle info
    public void displayVehicleInfo() {
        System.out.println("Vehicle ID     : " + vehicleId);
        System.out.println("Brand          : " + brand);
        System.out.println("Model          : " + model);
        System.out.println("Rent/Day       : " + rentPerDay);
        System.out.println("Available?     : " + (isAvailable ? "Yes" : "No"));
        System.out.println("Total Days Rented: " + totalRentedDays);
        System.out.println("----------------------------------");
    }

    // Static setters/getters
    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getAverageRentPerDay() {
        if (rentalDays == 0) return 0;
        return totalRevenue / rentalDays;
    }

    public static void displayCompanyStats() {
        System.out.println("=== Company Stats ===");
        System.out.println("Company Name    : " + companyName);
        System.out.println("Total Vehicles  : " + totalVehicles);
        System.out.println("Total Revenue   : " + totalRevenue);
        System.out.println("Total Rental Days: " + rentalDays);
        System.out.println("Avg Rent/Day    : " + getAverageRentPerDay());
        System.out.println("======================");
    }
}


public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Set company name (static shared property)
        Vehicle.setCompanyName("ZoomRentals");

        // Create vehicles (each has unique instance data)
        Vehicle v1 = new Vehicle("Toyota", "Camry", 1200);
        Vehicle v2 = new Vehicle("Honda", "Civic", 1000);
        Vehicle v3 = new Vehicle("Tesla", "Model 3", 2500);

        // Display initial info
        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();

        // Rent and return vehicles
        v1.rentVehicle(3);  // Toyota rented 3 days
        v2.rentVehicle(2);  // Honda rented 2 days
        v3.rentVehicle(5);  // Tesla rented 5 days
        v2.returnVehicle(); // Honda returned

        // Show updated info
        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();

        // Show static stats (shared across all vehicles)
        Vehicle.displayCompanyStats();
    }
}
