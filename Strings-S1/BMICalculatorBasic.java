import java.util.Scanner;

public class BMICalculatorBasic {

    // Method to compute BMI and status
    public static String[] computeBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0; // convert cm to meter
        double bmi = weight / (heightM * heightM);

        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        // return values as strings
        String[] result = new String[4];
        result[0] = "" + heightCm;
        result[1] = "" + weight;
        result[2] = String.format("%.2f", bmi);
        result[3] = status;

        return result;
    }

    // Method to prepare result table
    public static String[][] generateTable(double[][] hwArray) {
        String[][] table = new String[hwArray.length][4];

        for (int i = 0; i < hwArray.length; i++) {
            table[i] = computeBMI(hwArray[i][0], hwArray[i][1]);
        }
        return table;
    }

    // Method to display result
    public static void display(String[][] table) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1] + "\t\t" + table[i][2] + "\t\t" + table[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] hwArray = new double[10][2]; // 10 rows (persons), 2 columns (weight, height)

        // input for 10 persons
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1));
            System.out.print("Weight (kg): ");
            hwArray[i][0] = sc.nextDouble(); // weight
            System.out.print("Height (cm): ");
            hwArray[i][1] = sc.nextDouble(); // height
        }

        // generate result
        String[][] result = generateTable(hwArray);

        // display result
        System.out.println("\n=== BMI Report ===");
        display(result);

        sc.close();
    }
}
