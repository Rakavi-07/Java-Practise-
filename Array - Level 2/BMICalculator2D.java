import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3]; // [][0]=height, [][1]=weight, [][2]=BMI
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            double height, weight;
            do {
                System.out.print("Enter height (in meters) of person " + (i + 1) + ": ");
                height = sc.nextDouble();
                if (height <= 0) {
                    System.out.println("Height must be a positive value. Please enter again.");
                }
            } while (height <= 0);

            do {
                System.out.print("Enter weight (in kg) of person " + (i + 1) + ": ");
                weight = sc.nextDouble();
                if (weight <= 0) {
                    System.out.println("Weight must be a positive value. Please enter again.");
                }
            } while (weight <= 0);

            personData[i][0] = height;
            personData[i][1] = weight;
            personData[i][2] = weight / (height * height);

            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] >= 25 && personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\n--- BMI Report ---");
        System.out.println("Person\tHeight(m)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t%s\n", 
                (i + 1), personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

        sc.close();
    }
}
