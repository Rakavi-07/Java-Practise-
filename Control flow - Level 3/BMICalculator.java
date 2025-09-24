import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter weight in kg: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter height in cm: ");
        double height = scanner.nextDouble() / 100;        
        double bmi = weight / (height * height);
        String status;        if (bmi <= 18.4) status = "Underweight";
        else if (bmi <= 24.9) status = "Normal";
        else if (bmi <= 39.9) status = "Overweight";
        else status = "Obese";
        System.out.printf("BMI: %.2f (%s)\n", bmi, status);
        scanner.close();
    }
}

