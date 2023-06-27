package patterns.solidprinciple;

public class CorporateCustomer implements BankCustomer {
    private String companyId;
    private String companyName;

    public CorporateCustomer(String companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
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

    }

}
