package bankdao.entity;

public class Account {
    private int accountId;
    private String branchId;
    private String accountType;
    private double balance;
    private String accountHolderId;

    public Account() {

    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountHolderId() {
        return accountHolderId;
    }

    public void setAccountHolderId(String accountHolderId) {
        this.accountHolderId = accountHolderId;
    }

    // Constructors, toString(), equals(), and hashCode() methods

    public Account(int accountId, String branchId, String accountType, double balance, String accountHolderId) {
        this.accountId = accountId;
        this.branchId = branchId;
        this.accountType = accountType;
        this.balance = balance;
        this.accountHolderId = accountHolderId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", branchId='" + branchId + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", accountHolderId='" + accountHolderId + '\'' +
                '}';
    }
}