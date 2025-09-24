import java.util.Scanner;

public class UniqueCharacters {

    // Method to find length of string without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); // keep accessing until exception
                count++;
            }
        } catch (Exception e) {
            // when index goes out of bound, stop
        }
        return count;
    }

    // Method to find unique characters
    public static char[] findUnique(String text) {
        int len = findLength(text);
        char[] temp = new char[len]; // temporary array to store unique chars
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // check if current char is already in temp
            for (int j = 0; j < uniqueCount; j++) {
                if (temp[j] == current) {
                    isUnique = false;
                    break;
                }
            }

            // if unique, add to temp
            if (isUnique) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // create result array with only uniqueCount size
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input string
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // find unique chars
        char[] uniqueChars = findUnique(text);

        // display result
        System.out.print("Unique characters: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }

        sc.close();
    }
}
