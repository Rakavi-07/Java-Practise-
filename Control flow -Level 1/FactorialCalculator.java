import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a positive integer:");
        int n = input.nextInt();

        if (n < 0) {
            System.out.println("The number " + n + " is not a positive integer.");
        } else {
            long factorial = 1;

            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }

            System.out.println("The factorial of " + n + " is: " + factorial);
        }

        input.close();
    }
}
