import java.util.Scanner;

public class PrimeNumberChecker {
    public static void checkPrime() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check if it's prime: ");
        int num = scanner.nextInt();
        boolean isPrime = num > 1;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println(num + (isPrime ? " is a Prime Number." : " is NOT a Prime Number."));
        scanner.close();
    }

    public static void main(String[] args) {
        checkPrime();
    }
}
