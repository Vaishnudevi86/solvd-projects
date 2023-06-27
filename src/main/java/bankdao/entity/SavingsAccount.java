package bankdao.entity;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class SavingsAccount extends Account {
    @XmlElement(name = "interestRate")
    private double interestRate;

    @XmlElementWrapper(name = "holders")
    @XmlElement(name = "holder")
    private List<String> holders;

    public SavingsAccount() {
    }

    public SavingsAccount(double interestRate, List<String> holders) {
        this.interestRate = interestRate;
        this.holders = holders;
    }

      public SavingsAccount(int account_id, String branch_id, String account_type, double balance, String account_holder_id) {
        super(account_id, branch_id, account_type, balance, account_holder_id);
    }

    public SavingsAccount(String accountNumber, double accountBalance, double interestRate) {
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "interestRate=" + interestRate +
                ", holders=" + holders +
                '}';
    }
// Getters and setters

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public List<String> getHolders() {
        return holders;
    }

    public void setHolders(List<String> holders) {
        this.holders = holders;
    }
}