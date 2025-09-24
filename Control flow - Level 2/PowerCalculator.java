import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the base number:");
        int number = input.nextInt();
        
        System.out.println("Enter the exponent:");
        int power = input.nextInt();
        
        int result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }
        
        System.out.println(number + " raised to the power of " + power + " is: " + result);
        input.close();
    }
}
