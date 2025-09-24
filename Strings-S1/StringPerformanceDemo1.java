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
            sb.append(text); // modifies same object
        }
        long sbTime = System.currentTimeMillis() - start;

        // 3. StringBuffer (Thread-safe)
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text); // thread-safe
        }
        long sbfTime = System.currentTimeMillis() - start;

        // Output results
        System.out.println("String concatenation time: " + stringTime + " ms");
        System.out.println("StringBuilder time: " + sbTime + " ms");
        System.out.println("StringBuffer time: " + sbfTime + " ms");
    }
}
