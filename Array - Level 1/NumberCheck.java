import java.util.Scanner;
public class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        for (int num : numbers) {
            if (num > 0) {
                System.out.print(num + " is positive and ");
                if (num % 2 == 0)
                    System.out.println("even.");
                else
                    System.out.println("odd.");
            } else if (num < 0) {
                System.out.println(num + " is negative.");
            } else {
                System.out.println(num + " is zero.");
            }
        }
        if (numbers[0] > numbers[4]) {
            System.out.println("First number is greater than last number.");
        } else if (numbers[0] < numbers[4]) {
            System.out.println("First number is less than last number.");
        } else {
            System.out.println("First and last numbers are equal.");
        }
       
    }
}
