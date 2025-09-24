import java.util.Scanner;

class BankAccount {
    int accNumber;
    String accHolderName;
    float balance;

    BankAccount(int num, String name, float bal) {
        accNumber = num;
        accHolderName = name;
        balance = bal;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("New Balance: " + balance);
    }

    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
        System.out.println("New Balance: " + balance);
    }

    // 🔹 Added transfer method
    void transfer(BankAccount receiver, double amount) {
        balance -= amount;
        receiver.balance += amount;
        System.out.println("Transferred: " + amount + " to " + receiver.accHolderName);
        System.out.println("Your New Balance: " + balance);
    }
}

class Demonstration {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        BankAccount B1 = new BankAccount(101, "Abi", 10000);
        BankAccount B2 = new BankAccount(102, "Ravi", 5000);

        System.out.print("Enter amount to deposit: ");
        double depositAmount = input.nextDouble();
        B1.deposit(depositAmount);

        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = input.nextDouble();
        B1.withdraw(withdrawAmount);


        System.out.print("Enter amount to transfer from Abi to Ravi: ");
        double transferAmount = input.nextDouble();
        B1.transfer(B2, transferAmount);

        input.close();
    }
}

