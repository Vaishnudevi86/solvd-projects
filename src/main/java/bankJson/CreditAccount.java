package bankJson;

import java.util.List;

public class CreditAccount extends Account {
    private double creditLimit;

    // getters and setters

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public CreditAccount() {
    }

    public CreditAccount(String accountNumber, double balance, List<String> holders) {
        super(accountNumber, balance, holders);
    }

    public CreditAccount(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public CreditAccount(String accountNumber, double balance, List<String> holders, double creditLimit) {
        super(accountNumber, balance, holders);
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "creditLimit=" + creditLimit +
                '}';
    }
}