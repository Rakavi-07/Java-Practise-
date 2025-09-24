import java.util.Scanner;

public class AdvancedStringAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ADVANCED STRING ANALYZER ===");

        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        performAllComparisons(str1, str2);
        System.out.println("Similarity: " + calculateSimilarity(str1, str2) + "%");

        analyzeMemoryUsage(str1, str2);
        demonstrateStringIntern();
        scanner.close();
    }

    public static double calculateSimilarity(String str1, String str2) {
        int maxLen = Math.max(str1.length(), str2.length());
        int matches = 0;
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) == str2.charAt(i)) matches++;
        }
        return (matches / (double) maxLen) * 100;
    }

    public static void performAllComparisons(String str1, String str2) {
        System.out.println("Reference equality (==): " + (str1 == str2));
        System.out.println("Content equality (equals): " + str1.equals(str2));
        System.out.println("Case-insensitive equality: " + str1.equalsIgnoreCase(str2));
        System.out.println("Lexicographic comparison: " + str1.compareTo(str2));
        System.out.println("Case-insensitive lexicographic: " + str1.compareToIgnoreCase(str2));
    }

    public static void analyzeMemoryUsage(String... strings) {
        for (String s : strings) {
            System.out.println("'" + s + "' approx memory: " + (40 + s.length() * 2) + " bytes");
        }
    }

    public static String optimizedStringProcessing(String[] inputs) {
        StringBuilder sb = new StringBuilder();
        for (String s : inputs) sb.append(s).append(" ");
        return sb.toString().trim();
    }

    public static void demonstrateStringIntern() {
        String a = new String("Java");
        String b = "Java";
        System.out.println("Before intern: " + (a == b));
        a = a.intern();
        System.out.println("After intern: " + (a == b));
    }
}
