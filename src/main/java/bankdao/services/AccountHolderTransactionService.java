package bankdao.services;

import bankdao.interfaces.AccountHolderTransactionDAO;
import bankdao.model.AccountHolderTransaction;

import java.util.List;

public class AccountHolderTransactionService {
    private AccountHolderTransactionDAO accountHolderTransactionDAO;

    public AccountHolderTransactionService(AccountHolderTransactionDAO accountHolderTransactionDao) {
        this.accountHolderTransactionDAO = accountHolderTransactionDao ;
    }

    public AccountHolderTransaction getAccountHolderTransactionById(int id) {
        return accountHolderTransactionDAO.getAccountHolderTransactionById(id);
    }

    public List<AccountHolderTransaction> getAllAccountHolderTransaction() {
        return accountHolderTransactionDAO.getAllAccountHolderTransaction();
    }

    public void saveAccountHolderTransaction(AccountHolderTransaction accountHolderTransaction) {
        accountHolderTransactionDAO.save(accountHolderTransaction);
    }

    public void updateAccountHolderTransaction(AccountHolderTransaction accountHolderTransaction) {
        accountHolderTransactionDAO.update(accountHolderTransaction);
    }

    public void deleteAccountHolderTransaction(AccountHolderTransaction accountHolderTransaction) {
        accountHolderTransactionDAO.delete(accountHolderTransaction);
    }
}

