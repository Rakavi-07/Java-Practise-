// Parent class
class BasicMath {
    // Add two integers
    public int calculate(int a, int b) {
        return a + b;
    }

    // Multiply two doubles
    public double calculate(double a, double b) {
        return a * b;
    }

    // Subtract three integers
    public int calculate(int a, int b, int c) {
        return a - b - c;
    }
}

// Child class
class AdvancedMath extends BasicMath {
    // Divide two integers
    public double calculate(int a, double b) {
        return a / b;
    }

    // Power function
    public double calculate(double base, int exponent) {
        return Math.pow(base, exponent);
    }
}

// Main class
public class MathDemo {
    public static void main(String[] args) {
        AdvancedMath math = new AdvancedMath();

        System.out.println("Addition (int, int): " + math.calculate(10, 5));         // from parent
        System.out.println("Multiplication (double, double): " + math.calculate(2.5, 3.5)); // from parent
        System.out.println("Subtraction (int, int, int): " + math.calculate(20, 5, 3)); // from parent
        System.out.println("Division (int, double): " + math.calculate(10, 2.0));   // from child
        System.out.println("Power (double, int): " + math.calculate(2.0, 3));       // from child
    }
}
