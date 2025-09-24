import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Process each character
        for (char ch : input.toCharArray()) {
            int ascii = (int) ch;
            System.out.print("'" + ch + "' -> ASCII: " + ascii);
            String type = classifyCharacter(ch);
            System.out.print(" | Type: " + type);

            if (type.contains("Letter")) {
                char upper = Character.toUpperCase(ch);
                char lower = Character.toLowerCase(ch);
                System.out.print(" | Upper: '" + upper + "' (" + (int) upper + ")");
                System.out.print(" | Lower: '" + lower + "' (" + (int) lower + ")");
                System.out.print(" | Diff: " + Math.abs(upper - lower));
            }
            System.out.println();
        }

        // ASCII Art
        System.out.println("\nASCII Art:");
        for (char ch : input.toCharArray()) {
            for (int i = 0; i < (int) ch % 10 + 1; i++) {
                System.out.print(ch);
            }
            System.out.println();
        }

        // Caesar Cipher (+3 shift)
        System.out.println("\nCaesar Cipher (+3): " + caesarCipher(input, 3));

        // ASCII Table Example
        System.out.println("\nASCII Table (65 to 70):");
        displayASCIITable(65, 70);

        // Convert string to ASCII array and back
        int[] asciiArr = stringToASCII(input);
        System.out.print("\nASCII Array: ");
        for (int code : asciiArr) System.out.print(code + " ");
        System.out.println("\nConverted back to string: " + asciiToString(asciiArr));

        scanner.close();
    }

    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        if (Character.isLowerCase(ch)) return "Lowercase Letter";
        if (Character.isDigit(ch)) return "Digit";
        return "Special Character";
    }

    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) return (char) (ch + 32); // Upper -> Lower
        if (Character.isLowerCase(ch)) return (char) (ch - 32); // Lower -> Upper
        return ch; // Non-letter remains same
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + shift) % 26 + base);
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " -> " + (char) i);
        }
    }

    public static int[] stringToASCII(String text) {
        int[] arr = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = text.charAt(i);
        }
        return arr;
    }

    public static String asciiToString(int[] asciiValues) {
        StringBuilder sb = new StringBuilder();
        for (int code : asciiValues) {
            sb.append((char) code);
        }
        return sb.toString();
    }
}
