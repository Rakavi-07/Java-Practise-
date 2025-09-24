import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double first = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double second = scanner.nextDouble();
        
        System.out.print("Enter operator (+, -, *, /): ");
        String op = scanner.next();
        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;
            case "-":
                System.out.println("Result: " + (first - second));
                break;
            case "*":
                System.out.println("Result: " + (first * second));
                break;
            case "/":
                System.out.println("Result: " + (first / second));
                break;
            default:
                System.out.println("Invalid Operator.");
        }
        
        scanner.close();
    }
}
