import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine().trim();

        System.out.println("Trimmed: " + text);
        System.out.println("Spaces -> _: " + text.replace(" ", "_"));
        System.out.println("No digits: " + text.replaceAll("\\d", ""));
        String[] words = text.split("\\s+");
        System.out.println("Words: " + Arrays.toString(words));
        System.out.println("Joined with | : " + String.join(" | ", words));

        String noPunct = text.replaceAll("\\p{Punct}", "");
        System.out.println("No punctuation: " + noPunct);
        System.out.println("Capitalized: " + capitalizeWords(noPunct));
        System.out.println("Reversed words: " + reverseWords(noPunct));

        sc.close();
    }

    static String capitalizeWords(String t) {
        StringBuilder sb = new StringBuilder();
        for (String w : t.split("\\s+")) sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" ");
        return sb.toString().trim();
    }

    static String reverseWords(String t) {
        String[] w = t.split("\\s+");
        Collections.reverse(Arrays.asList(w));
        return String.join(" ", w);
    }
}

