import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter ages of Amar, Akbar, and Anthony:");
        int ageAmar = input.nextInt();
        int ageAkbar = input.nextInt();
        int ageAnthony = input.nextInt();

        System.out.println("Enter heights of Amar, Akbar, and Anthony:");
        int heightAmar = input.nextInt();
        int heightAkbar = input.nextInt();
        int heightAnthony = input.nextInt();

        int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        int tallestHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));

        System.out.println("Youngest friend is " + youngestAge + " years old.");
        System.out.println("Tallest friend is " + tallestHeight + " cm tall.");

        input.close();
    }
}