public class StringArrays {

    // Method to find the longest name in the array
    public static String findLongestName(String[] names) {
        String longest = "";
        for (String name : names) {
            if (name.length() > longest.length()) {
                longest = name;
            }
        }
        return longest;
    }

    // Method to count how many names start with a given letter (case-insensitive)
    public static int countNamesStartingWith(String[] names, char letter) {
        int count = 0;
        char target = Character.toLowerCase(letter);
        for (String name : names) {
            if (!name.isEmpty() && Character.toLowerCase(name.charAt(0)) == target) {
                count++;
            }
        }
        return count;
    }

    // Method to format names from "First Last" to "Last, First"
    public static String[] formatNames(String[] names) {
        String[] formatted = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            if (parts.length == 2) {
                formatted[i] = parts[1] + ", " + parts[0];
            } else {
                formatted[i] = names[i]; // Keep original if not exactly 2 parts
            }
        }
        return formatted;
    }

    public static void main(String[] args) {
        String[] students = {
            "John Smith", "Alice Johnson", "Bob Brown",
            "Carol Davis", "David Wilson"
        };

        // Test findLongestName
        String longestName = findLongestName(students);
        System.out.println("Longest name: " + longestName);

        // Test countNamesStartingWith
        char letter = 'D';
        int count = countNamesStartingWith(students, letter);
        System.out.println("Names starting with '" + letter + "': " + count);

        // Test formatNames
        String[] formattedNames = formatNames(students);
        System.out.println("Formatted names:");
        for (String name : formattedNames) {
            System.out.println(name);
        }
    }
}
