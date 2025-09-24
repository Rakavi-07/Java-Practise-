import java.util.Scanner;

public class CharacterFrequency {

    // Method to find frequency of characters
    public static String[] findFrequency(String text) {
        char[] chars = text.toCharArray();   // convert string to character array
        int[] freq = new int[chars.length]; // frequency array

        // Outer loop → pick each character
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1; // initial count

            if (chars[i] == '0') {
                continue; // already visited (skip)
            }

            // Inner loop → check duplicates
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark as visited
                }
            }
        }

        // Count how many unique chars we have
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        // Store results in 1D String array
        String[] result = new String[count];
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[k] = chars[i] + " = " + freq[i];
                k++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input string
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // call method
        String[] frequencies = findFrequency(text);

        // display result
        System.out.println("Character Frequencies:");
        for (String s : frequencies) {
            System.out.println(s);
        }

        sc.close();
    }
}

