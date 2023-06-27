package patterns.builders;

import bankdao.entity.CreditAccount;

public class CreditAccountBuilder {
    private int accountId;
    private String branchId;
    private String accountType;
    private double balance;
    private String accountHolderId;
    private double creditLimit;

    public CreditAccountBuilder setAccountId(int accountId) {
        this.accountId = accountId;
        return this;
    }

    public CreditAccountBuilder setBranchId(String branchId) {
        this.branchId = branchId;
        return this;
    }

    public CreditAccountBuilder setAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public CreditAccountBuilder setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public CreditAccountBuilder setAccountHolderId(String accountHolderId) {
        this.accountHolderId = accountHolderId;
        return this;
    }

    public CreditAccountBuilder setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
        return this;
    }

    public CreditAccount build() {
        return new CreditAccount(accountId, branchId, accountType, balance, accountHolderId, creditLimit);
    }
}