import java.util.Scanner; 

public class Smallestnum {
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter num1 num2 num3:");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();

        if (num1 < num2 || num1 < num3) {  
            System.out.println("Is the first number the smallest? Yes!");
        } else {
            System.out.println("Is the first number the smallest? No!");
        }

        input.close(); 
    }
}

