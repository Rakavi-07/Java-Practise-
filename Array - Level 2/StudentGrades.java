import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int num = sc.nextInt();

        double[][] marks = new double[num][3];
        double[] percentage = new double[num];
        String[] grade = new String[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                double mark;
                do {
                    System.out.print(subject + " marks: ");
                    mark = sc.nextDouble();
                    if (mark < 0) {
                        System.out.println("Marks should be positive. Enter again.");
                    }
                } while (mark < 0);
                marks[i][j] = mark;
            }
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            if (percentage[i] >= 90) grade[i] = "A";
            else if (percentage[i] >= 80) grade[i] = "B";
            else if (percentage[i] >= 70) grade[i] = "C";
            else if (percentage[i] >= 60) grade[i] = "D";
            else grade[i] = "F";
        }

        System.out.println("\n--- Student Result ---");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < num; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t\t%.2f\t%.2f\t\t%s\n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }
        sc.close();
    }
}
