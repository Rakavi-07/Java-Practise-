import java.util.Scanner;

public class CharFrequency {

    // Method to find frequency of characters
    public static String[][] findFrequency(String text) {
        int[] freq = new int[256]; // store frequency for ASCII chars

        // Step 1: Count frequency using charAt()
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            freq[c]++;
        }

        // Step 2: Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (freq[c] > 0) {
                uniqueCount++;
                freq[c] = -freq[c]; // mark visited
            }
        }

        // Step 3: Prepare result 2D array [uniqueCount][2]
        String[][] result = new String[uniqueCount][2];
        int index = 0;

        // Reset freq by recounting (since we marked them negative)
        freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        // Step 4: Store character and frequency
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (freq[c] > 0) {
                result[index][0] = String.valueOf(c);
                result[index][1] = String.valueOf(freq[c]);
                freq[c] = 0; // mark as processed
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Get frequency result
        String[][] frequencies = findFrequency(text);

        // Display result
        System.out.println("Character Frequencies:");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(frequencies[i][0] + " = " + frequencies[i][1]);
        }

        sc.close();
    }
}

