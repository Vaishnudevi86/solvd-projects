package bankdao.entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class CreditAccount extends Account {
    @XmlElement(name = "creditLimit")
    private double creditLimit;

    @XmlElementWrapper(name = "holders")
    @XmlElement(name = "holder")
    private List<String> holders;

    public CreditAccount() {
    }

    public CreditAccount(int account_id, String branch_id, String account_type, double balance, String account_holder_id) {
        super(account_id, branch_id, account_type, balance, account_holder_id);
    }

    public CreditAccount(double creditLimit, List<String> holders) {
        this.creditLimit = creditLimit;
        this.holders = holders;
    }

    public CreditAccount(int accountId, String branchId, String accountType, double balance, String accountHolderId, double creditLimit, List<String> holders) {
        super(accountId, branchId, accountType, balance, accountHolderId);
        this.creditLimit = creditLimit;
        this.holders = holders;
    }

     public CreditAccount(int accountId, String branchId, String accountType, double balance, String accountHolderId, double creditLimit) {
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "creditLimit=" + creditLimit +
                ", holders=" + holders +
                '}';
    }


// Getters and setters

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public List<String> getHolders() {
        return holders;
    }

    public void setHolders(List<String> holders) {
        this.holders = holders;
    }
}
