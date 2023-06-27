package patterns.solidprinciple;

public class IndividualCustomer implements BankCustomer, AccountHolder {
    private String customerId;
    private String name;

    public IndividualCustomer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    @Override
    public void deposit(double amount) {
        // Implementation for deposit operation
        System.out.println("Depositing $" + amount);
    }

    @Override
    public void withdraw(double amount) {
        // Implementation for withdraw operation
        System.out.println("Withdrawing $" + amount);
    }

    @Override
    public void transferFunds(int i, String recipientAccount123) {

    }

    @Override
    public void checkBalance() {
        // Implementation for checking account balance
        System.out.println("Checking account balance");
    }

    @Override
    public void transferFunds(double amount, String recipientAccount) {
        // Implementation for transferring funds to another account
        System.out.println("Transferring $" + amount + " to account " + recipientAccount);
    }

  }
