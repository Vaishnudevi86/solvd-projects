package patterns.solidprinciple;

public class Account implements BankingOperations, AccountInformation, AccountManagement {
    private int accountId;
    private double balance;
    @Override
    public void closeAccount() {
        // Close account implementation
    }


    public Account(int accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;

    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }


    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }

    }
}