import java.util.*;

public class TextProcessor {

    public static String cleanInput(String input) {
        input = input.trim();

        StringBuilder cleaned = new StringBuilder();
        boolean capitalizeNext = true;
        for (char ch : input.toCharArray()) {
            if (capitalizeNext && Character.isLetter(ch)) {
                cleaned.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                cleaned.append(Character.toLowerCase(ch));
            }
            if (ch == '.' || ch == '!' || ch == '?') {
                capitalizeNext = true;
            }
        }
        return cleaned.toString();
    }

    public static void analyzeText(String text) {
        if (text.isEmpty()) {
            System.out.println("No text to analyze.");
            return;
        }

        int charCount = text.replace(" ", "").length();

        String[] words = text.split("\\s+");
        int wordCount = words.length;

        String[] sentences = text.split("[.!?]+");
        int sentenceCount = sentences.length;

        String longestWord = "";
        for (String w : words) {
            String cleanWord = w.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.length() > longestWord.length()) {
                longestWord = cleanWord;
            }
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
        }

        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostCommonChar = entry.getKey();
            }
        }

        System.out.println("\n=== Text Analysis ===");
        System.out.println("Words count: " + wordCount);
        System.out.println("Sentences count: " + sentenceCount);
        System.out.println("Characters count (excluding spaces): " + charCount);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Most common character: '" + mostCommonChar + "' appeared " + maxFreq + " times");
    }

    public static String[] getWordsSorted(String text) {
        String cleanedText = text.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
        String[] words = cleanedText.split("\\s+");
        Arrays.sort(words);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph of text: ");
        String input = scanner.nextLine();

        String cleanedText = cleanInput(input);
        System.out.println("\nCleaned Text:\n" + cleanedText);

        analyzeText(cleanedText);

        String[] sortedWords = getWordsSorted(cleanedText);
        System.out.println("\nWords in alphabetical order:");
        for (String w : sortedWords) {
            System.out.println(w);
        }

        while (true) {
            System.out.print("\nEnter a word to search (or type 'exit' to quit): ");
            String searchWord = scanner.nextLine().trim().toLowerCase();
            if (searchWord.equals("exit")) {
                break;
            }
            int count = 0;
            for (String w : sortedWords) {
                if (w.equals(searchWord)) {
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("The word '" + searchWord + "' appears " + count + " time(s) in the text.");
            } else {
                System.out.println("The word '" + searchWord + "' does not appear in the text.");
            }
        }

        System.out.println("Thank you for using the Text Processor.");
        scanner.close();
    }
}
