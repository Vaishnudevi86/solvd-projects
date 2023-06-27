package patterns.solidprinciple;

public interface AccountHolder {
    void checkBalance();
    void transferFunds(double amount, String recipientAccount);
}
