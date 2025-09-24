public class SecureBankAccount {
    private String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance >= MIN_BALANCE ? initialBalance : MIN_BALANCE;
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        if (isLocked) {
            System.out.println("Account is locked. Cannot access balance.");
            return -1;
        }
        return balance;
    }

    public boolean isAccountLocked() {
        return isLocked;
    }

    public void setPin(int oldPin, int newPin) {
        if (this.pin == oldPin) {
            this.pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect old PIN. PIN not changed.");
        }
    }

    public boolean validatePin(int enteredPin) {
        if (isLocked) {
            System.out.println("Account is locked. Cannot validate PIN.");
            return false;
        }
        if (enteredPin == this.pin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            return false;
        }
    }

    public void unlockAccount(int correctPin) {
        if (this.pin == correctPin) {
            isLocked = false;
            resetFailedAttempts();
            System.out.println("Account unlocked.");
        } else {
            System.out.println("Incorrect PIN. Account remains locked.");
        }
    }

    public void deposit(double amount, int pin) {
        if (validatePin(pin)) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount);
            }
        }
    }

    public void withdraw(double amount, int pin) {
        if (validatePin(pin)) {
            if (amount > 0 && balance - amount >= MIN_BALANCE) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient balance.");
            }
        }
    }

    public void transfer(SecureBankAccount target, double amount, int pin) {
        if (validatePin(pin)) {
            if (amount > 0 && balance - amount >= MIN_BALANCE) {
                this.balance -= amount;
                target.balance += amount;
                System.out.println("Transferred: " + amount + " to " + target.getAccountNumber());
            } else {
                System.out.println("Insufficient funds for transfer.");
            }
        }
    }

    private void lockAccount() {
        isLocked = true;
        System.out.println("Account locked due to too many failed attempts.");
    }

    private void resetFailedAttempts() {
        failedAttempts = 0;
    }

    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            lockAccount();
        }
    }

    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("A1001", 5000);
        SecureBankAccount acc2 = new SecureBankAccount("A2001", 3000);

        acc1.setPin(0, 1234);
        acc2.setPin(0, 5678);

        acc1.deposit(2000, 1234);
        acc1.withdraw(1000, 1234);

        acc1.transfer(acc2, 1500, 1234);

        acc1.withdraw(10000, 1234); // Insufficient funds
        acc1.validatePin(1111);
        acc1.validatePin(2222);
        acc1.validatePin(3333); // Should lock account

        acc1.withdraw(500, 1234); // Should fail, account locked
        acc1.unlockAccount(1234); // Unlock
        acc1.withdraw(500, 1234); // Works after unlock
    }
}
