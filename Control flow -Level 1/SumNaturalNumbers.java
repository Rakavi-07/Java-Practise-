import java.util.Scanner;

public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a natural number:");
        int n = input.nextInt();

        if (n < 0) {
            System.out.println("The number " + n + " is not a natural number.");
        } else {
            int sumFormula = n * (n + 1) / 2;
            int sumWhileLoop = 0;
            int i = 1;

            while (i <= n) {
                sumWhileLoop += i;
                i++;
            }

            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using while loop: " + sumWhileLoop);

            if (sumFormula == sumWhileLoop) {
                System.out.println("Both computations match! ");
            } else {
                System.out.println("There is an error in computation. ");
            }
        }

        input.close();
    }
}
