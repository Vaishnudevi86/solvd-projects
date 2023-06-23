package bankdao.services;


import bankdao.entity.Account;
import bankdao.interfaces.AccountDAO;

import java.sql.SQLException;
import java.util.List;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(AccountDAO accountDao) {
        this.accountDAO = accountDao ;
    }

    public Account getAccountById(int id) {
        return accountDAO.getAccountById(id);
    }

    public List<Account> getAllAccount() {
        return accountDAO.getAllAccount();
    }

    public void saveAccount(Account account) {
        accountDAO.save(account);
    }

    public void updateAccount(Account account) throws SQLException {
        accountDAO.update(account);
    }

    public void deleteAccount(int accountId) {
        accountDAO.delete(accountId);
    }
}


