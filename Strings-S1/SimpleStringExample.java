import java.util.Scanner;

public class SimpleStringExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String input = scanner.nextLine();

        System.out.println("\nYou entered: " + input);

        String upper = input.toUpperCase();
        System.out.println("Uppercase: " + upper);

        String lower = input.toLowerCase();
        System.out.println("Lowercase: " + lower);

        int length = input.length();
        System.out.println("Length: " + length);

        System.out.print("\nEnter a word to search: ");
        String word = scanner.nextLine();
        boolean contains = input.contains(word);
        System.out.println("Contains \"" + word + "\"? " + contains);

        scanner.close();
    }
}
