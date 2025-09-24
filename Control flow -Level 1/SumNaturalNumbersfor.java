import java.util.Scanner;

public class SumNaturalNumbersfor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a natural number:");
        int n = input.nextInt();

        if (n < 0) {
            System.out.println("The number " + n + " is not a natural number.");
        } else {
            int sumFormula = n * (n + 1) / 2;
            int sumForLoop = 0;

            for (int i = 1; i <= n; i++) {
                sumForLoop += i;
            }

            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using for loop: " + sumForLoop);

            if (sumFormula == sumForLoop) {
                System.out.println("Both computations match! ");
            } else {
                System.out.println("There is an error in computation. ");
            }
        }

        input.close();
    }
}
