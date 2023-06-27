package patterns.solidprinciple;

public interface BankCustomer {
    void deposit(double amount);
    void withdraw(double amount);

    void transferFunds(int i, String recipientAccount123);

    void checkBalance();
}
