package patterns.solidprinciple;

//Open Closed Principle
public abstract class BankProduct {
    private int productId;
    private String productName;
    private double balance;

    public BankProduct(int productId, String productName, double balance) {
        this.productId = productId;
        this.productName = productName;
        this.balance = balance;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void displayProductDetails();
}