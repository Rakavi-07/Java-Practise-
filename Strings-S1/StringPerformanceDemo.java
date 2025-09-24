

public class StringPerformanceDemo {
    public static void main(String[] args) {
        int iterations = 5000; // Number of times we join text
        String text = "Java";

        System.out.println("=== PERFORMANCE TEST ===");
        System.out.println("Iterations: " + iterations);

        // 1. String concatenation
        long start = System.currentTimeMillis();
        String result1 = "";
        for (int i = 0; i < iterations; i++) {
            result1 += text; // new object created each time
        }
        long stringTime = System.currentTimeMillis() - start;

        // 2. StringBuilder
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long builderTime = System.currentTimeMillis() - start;

        // Output results
        System.out.println("String concatenation time: " + stringTime + " ms");
        System.out.println("StringBuilder time: " + builderTime + " ms");
    }
}