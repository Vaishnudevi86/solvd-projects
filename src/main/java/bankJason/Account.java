package bankJason;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SavingsAccount.class, name = "savingsAccount"),
        @JsonSubTypes.Type(value = CreditAccount.class, name = "creditAccount")
})
public class Account {
    private String accountNumber;
    private double balance;
    private List<String> holders;


    // Getters and setters

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<String> getHolders() {
        return holders;
    }

    public void setHolders(List<String> holders) {
        this.holders = holders;

    }

    public Account() {
    }

    public Account(String accountNumber, double balance, List<String> holders) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.holders = holders;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", holders=" + holders +
                '}';
    }
}