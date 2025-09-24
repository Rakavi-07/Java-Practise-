class BankAccount {
    // private instance variables
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // static variables
    private static int totalAccounts = 0;
    private static int accountCounter = 0; // helps generate unique account numbers

    // constructor
    public BankAccount(String accountHolderName, double initialDeposit) {
        if (initialDeposit < 0) {
            System.out.println("Initial deposit cannot be negative. Setting balance = 0.");
            initialDeposit = 0;
        }
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    // static method to generate account numbers
    private static String generateAccountNumber() {
        accountCounter++;
        return String.format("ACC%03d", accountCounter); // ACC001, ACC002...
    }

    // deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " into " + accountNumber);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    // withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
        } else if (amount > balance) {
            System.out.println("Insufficient funds in " + accountNumber);
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from " + accountNumber);
        }
    }

    // check balance
    public double checkBalance() {
        return balance;
    }

    // display account info
    public void displayAccountInfo() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : " + balance);
        System.out.println("------------------------------");
    }

    // static method to get total accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }
}

// Main class
public class BankSystem {
    public static void main(String[] args) {
        // create an array of BankAccount objects
        BankAccount[] accounts = new BankAccount[3];

        // creating accounts
        accounts[0] = new BankAccount("Alice", 1000);
        accounts[1] = new BankAccount("Bob", 500);
        accounts[2] = new BankAccount("Charlie", 2000);

        // perform some transactions
        accounts[0].deposit(500);
        accounts[1].withdraw(200);
        accounts[2].withdraw(2500); // should show insufficient funds

        // display account info
        for (int i = 0; i < accounts.length; i++) {
            accounts[i].displayAccountInfo();
        }

        // show total accounts created (static variable)
        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccounts());
    }
}
