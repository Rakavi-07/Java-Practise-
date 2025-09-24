import java.util.Scanner;

public class FizzBuzzwhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a positive integer:");
        int number = input.nextInt();

        if (number < 1) {
            System.out.println("The number " + number + " is not a positive integer.");
        } else {
            int i = 0;
            while (i <= number) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
                i++;
            }
        }

        input.close();
    }
}