package patterns.solidprinciple;

public class SavingsAccount extends BankProduct {
    private double interestRate;

    public SavingsAccount(int productId, String productName, double balance, double interestRate) {
        super(productId, productName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void displayProductDetails() {
        System.out.println("Savings Account Details");
        System.out.println("Product ID: " + getProductId());
        System.out.println("Product Name: " + getProductName());
        System.out.println("Balance: $" + getBalance());
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("-------------------------------");
    }
}