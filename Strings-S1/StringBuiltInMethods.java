public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";

        System.out.println("Original Text: '" + sampleText + "'");
        System.out.println("Original Length (with spaces): " + sampleText.length());

        String trimmed = sampleText.trim();
        System.out.println("Trimmed Text: '" + trimmed + "'");
        System.out.println("Trimmed Length: " + trimmed.length());

        System.out.println("Character at index 5: " + sampleText.charAt(5));


        System.out.println("Substring 'Programming': " + trimmed.substring(5, 16));

        System.out.println("Index of 'Fun': " + trimmed.indexOf("Fun"));

        System.out.println("Contains 'Java': " + trimmed.contains("Java"));

        System.out.println("Starts with 'Java': " + trimmed.startsWith("Java"));

      
        System.out.println("Ends with '!': " + trimmed.endsWith("!"));

        System.out.println("Uppercase: " + trimmed.toUpperCase());

        System.out.println("Lowercase: " + trimmed.toLowerCase());

       
        int vowelCount = countVowels(trimmed);
        System.out.println("Number of vowels: " + vowelCount);

       
        System.out.print("Occurrences of 'a': ");
        findAllOccurrences(trimmed, 'a');
    }

    public static int countVowels(String text) {
        int count = 0;
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if ("aeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
    public static void findAllOccurrences(String text, char target) {
        boolean found = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("No occurrences found.");
        }
        System.out.println();
    }
}
