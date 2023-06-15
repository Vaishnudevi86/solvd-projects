package bankJason;

import java.util.List;

public class SavingsAccount extends Account {
    private double interestRate;

    // getters and setters

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public SavingsAccount() {
    }

    public SavingsAccount(String accountNumber, double balance, List<String> holders) {
        super(accountNumber, balance, holders);
    }

    public SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    public SavingsAccount(String accountNumber, double balance, List<String> holders, double interestRate) {
        super(accountNumber, balance, holders);
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "interestRate=" + interestRate +
                '}';
    }
}