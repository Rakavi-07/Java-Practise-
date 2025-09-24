import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter month (1-12):");
        int month = input.nextInt();

        System.out.println("Enter day (1-31):");
        int day = input.nextInt();

        if ((month == 3 && day >= 20 && day <= 31) ||
            (month == 4 && day >= 1 && day <= 30) ||
            (month == 5 && day >= 1 && day <= 31) ||
            (month == 6 && day >= 1 && day <= 20)) {
            System.out.println("It's a Spring Season.");
        } else {
            System.out.println("Not a Spring Season.");
        }

        input.close();
    }
}
