import java.util.Scanner;

public class YoungHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] age = new double[3];
        double[] height = new double[3];
        String[] name = {"Amar", "Akbar", "Anthony"};

        
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the Age of " + name[i] + ":");
            age[i] = sc.nextDouble();

            System.out.println("Enter the Height of " + name[i] + ":");
            height[i] = sc.nextDouble();
        }

        
        double minAge = age[0];
        int youngest = 0;
        double maxHeight = height[0];
        int tallest = 0;

        
        for (int i = 1; i < 3; i++) {
            if (age[i] < minAge) {
                minAge = age[i];
                youngest = i;
            }
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                tallest = i;
            }
        }

        // Output
        System.out.println("\nThe youngest friend is " + name[youngest] + " with age " + minAge);
        System.out.println("The tallest friend is " + name[tallest] + " with height " + maxHeight + " feet");

        sc.close(); 
    }
}

  