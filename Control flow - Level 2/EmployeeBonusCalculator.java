import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your salary:");
        double salary = input.nextDouble();

        System.out.println("Enter your years of service:");
        int yearsOfService = input.nextInt();

        if (yearsOfService > 5) {
            double bonus = salary * 0.05;
            System.out.println("Your bonus amount is: " + bonus);
        } else {
            System.out.println("You are not eligible for a bonus.");
        }

        input.close();
    }
}
