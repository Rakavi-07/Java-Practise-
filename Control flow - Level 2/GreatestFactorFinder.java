import java.util.Scanner;

public class GreatestFactorFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number = input.nextInt();
        int greatestFactor = 1;

        for (int i = number - 1; i > 0; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break;
            }
        }

        System.out.println("Greatest factor of " + number + " (besides itself) is: " + greatestFactor);
        input.close();
    }
}
