package patterns.builders;

import bankdao.entity.SavingsAccount;

public class SavingsAccountBuilder {
    private int accountId;
    private String branchId;
    private String accountType;
    private double balance;
    private String accountHolderId;

    public SavingsAccountBuilder setAccountId(int accountId) {
        this.accountId = accountId;
        return this;
    }

    public SavingsAccountBuilder setBranchId(String branchId) {
        this.branchId = branchId;
        return this;
    }

    public SavingsAccountBuilder setAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public SavingsAccountBuilder setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public SavingsAccountBuilder setAccountHolderId(String accountHolderId) {
        this.accountHolderId = accountHolderId;
        return this;
    }

    public SavingsAccount build() {
        return new SavingsAccount(accountId, branchId, accountType, balance, accountHolderId);
    }
}