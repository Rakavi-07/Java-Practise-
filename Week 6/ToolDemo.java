// Parent class
class Tool {
    private String brand;     // Private: only inside Tool
    protected String type;    // Protected: accessible in child
    public int weight;        // Public: accessible everywhere

    // Constructor
    Tool(String brand, String type, int weight) {
        this.brand = brand;
        this.type = type;
        this.weight = weight;
    }

    // Getter for private field
    public String getBrand() {
        return brand;
    }
}

// Child class
class Hammer extends Tool {

    Hammer(String brand, String type, int weight) {
        super(brand, type, weight);
    }

    public void showAccess() {
        // System.out.println("Brand: " + brand); ❌ Cannot access private directly
        System.out.println("Brand (via getter): " + getBrand()); // ✅ Using getter
        System.out.println("Type (protected): " + type);         // ✅ Accessible
        System.out.println("Weight (public): " + weight);        // ✅ Accessible
    }
}

// Main class
public class ToolDemo {
    public static void main(String[] args) {
        Hammer h = new Hammer("Stanley", "Hand Tool", 5);

        System.out.println("Accessing from Hammer:");
        h.showAccess();

        System.out.println("\nAccessing from main:");
        // System.out.println(h.brand); ❌ Not accessible (private)
        // System.out.println(h.type);  ❌ Not accessible outside package without subclass
        System.out.println("Weight (public): " + h.weight); // ✅ Accessible
        System.out.println("Brand (via getter): " + h.getBrand()); // ✅ Accessible
    }
}
