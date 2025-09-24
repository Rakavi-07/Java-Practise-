import java.util.Scanner;
public class StoreValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];
        double sum = 0.0;
        int index = 0;
        while (true) {
            System.out.print("Enter a number: ");
            double num = sc.nextDouble();
            if (num <= 0 || index == 10) break;
            numbers[index++] = num;
        }
        for (int i = 0; i < index; i++) {
            sum += numbers[i];
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\nSum: " + sum);

    }
}
