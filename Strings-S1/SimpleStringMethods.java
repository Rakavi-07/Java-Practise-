
public class SimpleStringMethods {
    public static void main(String[] args) {
        String text = "Welcome to java ";

        System.out.println("Length: " + text.length());
        System.out.println("First 'a' at index: " + text.indexOf('a'));
        System.out.println("Substring(0,7): '" + text.substring(0, 7) + "'");
        System.out.println("Trimmed: '" + text.trim() + "'");
        System.out.println("Uppercase: " + text.toUpperCase());

        String other = " Welcome to Java";
        System.out.println("Equals Ignore Case: " + text.trim().equalsIgnoreCase(other.trim()));
    }
}
