// Abstract class for Account
abstract class Account {
    String accountHolder;
    double balance;

    Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    abstract void calculateInterest();
}

class SavingsAccount extends Account {
    SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    void calculateInterest() {
        double interest = balance * 0.04;  // 4% interest
        System.out.println("Savings Account Interest: " + interest);
    }
}

class CurrentAccount extends Account {
    CurrentAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }


    void calculateInterest() {
        System.out.println("Current Account Interest: 0 (No interest on current accounts)");
    }
}


class LoanAccount extends Account {
    LoanAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }


    void calculateInterest() {
        double interest = balance * 0.10;  // 10% loan interest
        System.out.println("Loan Account Interest: " + interest);
    }
}


public class BankingSystem {
    public static void main(String[] args) {
        Account s = new SavingsAccount("Alice", 5000);
        Account c = new CurrentAccount("Bob", 10000);
        Account l = new LoanAccount("Charlie", 20000);

        s.calculateInterest();
        c.calculateInterest();
        l.calculateInterest();
    }
}
