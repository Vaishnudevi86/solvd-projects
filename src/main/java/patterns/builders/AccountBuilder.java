package patterns.builders;

import bankdao.entity.Account;

public class AccountBuilder {
    private int accountId;
    private String branchId;
    private String accountType;
    private double balance;
    private String accountHolderId;

    public AccountBuilder withAccountId(int accountId) {
        this.accountId = accountId;
        return this;
    }

    public AccountBuilder withBranchId(String branchId) {
        this.branchId = branchId;
        return this;
    }

    public AccountBuilder withAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public AccountBuilder withBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public AccountBuilder withAccountHolderId(String accountHolderId) {
        this.accountHolderId = accountHolderId;
        return this;
    }

    public Account build() {
        Account account = new Account();
        account.setAccountId(accountId);
        account.setBranchId(branchId);
        account.setAccountType(accountType);
        account.setBalance(balance);
        account.setAccountHolderId(accountHolderId);
        return account;
    }

 }