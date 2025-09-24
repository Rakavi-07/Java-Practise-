import java.util.Scanner;
public class MultiplesFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = input.nextInt();
        System.out.println("Multiples of " + number + " below 100 are:");
        for (int i = 100; i > 0; i--) {
            if (i % number == 0) {
                System.out.println(i);
            }
        }
        input.close();
    }
}
