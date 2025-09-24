import java.util.Scanner;

public class StudentMarksGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        double[] physics = new double[n];
        double[] chemistry = new double[n];
        double[] maths = new double[n];
        double[] percentage = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");

            System.out.print("Physics marks: ");
            double p = sc.nextDouble();
            if (p < 0) {
                System.out.println("Invalid marks! Please enter positive value.");
                i--;
                continue;
            }
            physics[i] = p;

            System.out.print("Chemistry marks: ");
            double c = sc.nextDouble();
            if (c < 0) {
                System.out.println("Invalid marks! Please enter positive value.");
                i--;
                continue;
            }
            chemistry[i] = c;

            System.out.print("Maths marks: ");
            double m = sc.nextDouble();
            if (m < 0) {
                System.out.println("Invalid marks! Please enter positive value.");
                i--;
                continue;
            }
            maths[i] = m;

            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3;

            if (percentage[i] >= 90) grade[i] = "A";
            else if (percentage[i] >= 80) grade[i] = "B";
            else if (percentage[i] >= 70) grade[i] = "C";
            else if (percentage[i] >= 60) grade[i] = "D";
            else grade[i] = "F";
        }

        System.out.println("\nStudent Marks, Percentage, and Grades:");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t\t%.2f\t%.2f\t\t%s\n",
                    (i + 1), physics[i], chemistry[i], maths[i], percentage[i], grade[i]);
        }

        sc.close();
    }
}
