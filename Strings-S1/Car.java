public class Car {
    
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;

    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false; 
    }

    
    public void startEngine() {
        if (!isRunning) {
            isRunning = true;
            System.out.println(brand + " " + model + " engine started.");
        } else {
            System.out.println(brand + " " + model + " engine is already running.");
        }
    }

    public void stopEngine() {
        if (isRunning) {
            isRunning = false;
            System.out.println(brand + " " + model + " engine stopped.");
        } else {
            System.out.println(brand + " " + model + " engine is already off.");
        }
    }

    public void displayInfo() {
        System.out.println("Car Info:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Is Running: " + isRunning);
        System.out.println("--------------------------");
    }

    public int getAge(int currentYear) {
        return currentYear - year;
    }

    public static void main(String[] args) {
        // Creating 3 different Car objects
        Car car1 = new Car("Toyota", "Corolla", 2018, "Red");
        Car car2 = new Car("Tesla", "Model 3", 2022, "White");
        Car car3 = new Car("Ford", "Mustang", 2015, "Black");

        car1.displayInfo();
        car1.startEngine();
        car1.stopEngine();
        System.out.println(car1.brand + " age: " + car1.getAge(2025) + " years\n");

        car2.displayInfo();
        car2.startEngine();
        System.out.println(car2.brand + " age: " + car2.getAge(2025) + " years\n");

        car3.displayInfo();
        car3.startEngine();
        car3.stopEngine();
        System.out.println(car3.brand + " age: " + car3.getAge(2025) + " years\n");


    }
}
