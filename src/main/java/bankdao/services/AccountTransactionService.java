package bankdao.services;

import bankdao.interfaces.AccountTransactionDAO;
import bankdao.entity.AccountTransaction;

import java.util.List;

public class AccountTransactionService {
    private AccountTransactionDAO accountTransactionDAO;

    public AccountTransactionService(AccountTransactionDAO accountTransactionDao) {
        this.accountTransactionDAO = accountTransactionDao ;
    }

    public AccountTransaction getAccountTransactionById(int id) {
        return accountTransactionDAO.getAccountTransactionById(id);
    }

    public List<AccountTransaction> getAllAccountTransaction() {
        return accountTransactionDAO.getAllAccountTransaction();
    }

    public void saveAccountTransaction(AccountTransaction accountTransaction) {
        accountTransactionDAO.save(accountTransaction);
    }

    public void updateAccountTransaction(AccountTransaction accountTransaction) {
        accountTransactionDAO.update(accountTransaction);
    }

    public void deleteAccountTransaction(AccountTransaction accountTransaction) {
        accountTransactionDAO.delete(accountTransaction);
    }
}


