package bankdao.entity;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class SavingsAccountEntity extends AccountEntity {
    @XmlElement(name = "interestRate")
    private double interestRate;

    @XmlElementWrapper(name = "holders")
    @XmlElement(name = "holder")
    private List<String> holders;

    public SavingsAccountEntity() {
    }

    public SavingsAccountEntity(double interestRate, List<String> holders) {
        this.interestRate = interestRate;
        this.holders = holders;
    }

      public SavingsAccountEntity(int account_id, int branch_id, String account_type, double balance, int account_holder_id) {
        super(account_id, branch_id, account_type, balance, account_holder_id);
    }

    public SavingsAccountEntity(String accountNumber, double accountBalance, double interestRate) {
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