// Parent class
class Light {
    String type;
    int watt;

    // Default constructor
    Light() {
        this("Generic Light", 0);  // calls parameterized constructor
        System.out.println("Light: Default constructor called");
    }

    // Parameterized constructor with one argument
    Light(String type) {
        this(type, 0);  // calls two-parameter constructor
        System.out.println("Light: Constructor with type called");
    }

    // Parameterized constructor with two arguments
    Light(String type, int watt) {
        this.type = type;
        this.watt = watt;
        System.out.println("Light: Constructor with type & watt called");
    }
}

// Child class
class LED extends Light {
    String color;

    // Default constructor
    LED() {
        this("White");  // calls constructor with one parameter
        System.out.println("LED: Default constructor called");
    }

    // Parameterized constructor with one argument
    LED(String color) {
        super("LED Light", 10);  // calls parent constructor
        this.color = color;
        System.out.println("LED: Constructor with color called");
    }
}

// Main class
public class LightDemo {
    public static void main(String[] args) {
        System.out.println("Creating Light object:");
        Light l1 = new Light();

        System.out.println("\nCreating LED object:");
        LED led1 = new LED();
    }
}
