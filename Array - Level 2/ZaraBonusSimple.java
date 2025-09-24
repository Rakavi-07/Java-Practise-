
import java.util.Scanner;

public class ZaraBonusSimple {
    public static void main(String[] args) {
        double[] salary = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;
        Scanner sc = new Scanner(System.in);
      
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter salary for Employee " + (i + 1) + ": ");
            double s = sc.nextDouble();
            salary[i] = s;

            System.out.println("Enter years of service for Employee " + (i + 1) + ": ");
            double y = sc.nextDouble();
            years[i] = y;
        }

        for (int i = 0; i < 10; i++) {
            if (years[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }
     
        System.out.println("\n--- Employee Bonus and Salary Details ---");
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) + ": Old Salary = " + salary[i] + ", Bonus = " + bonus[i] + ", New Salary = " + newSalary[i]);
        }
        System.out.println("\n--- Totals ---");
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Paid: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}
