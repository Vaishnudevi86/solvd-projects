package bankdao.services;


import bankdao.entity.AccountEntity;
import bankdao.interfaces.AccountDAO;

import java.sql.SQLException;
import java.util.List;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(AccountDAO accountDao) {
        this.accountDAO = accountDao ;
    }

    public AccountEntity getAccountById(int id) {
        return accountDAO.getAccountById(id);
    }

    public List<AccountEntity> getAllAccount() {
        return accountDAO.getAllAccount();
    }

    public void saveAccount(AccountEntity accountEntity) {
        accountDAO.save(accountEntity);
    }

    public void updateAccount(AccountEntity accountEntity) throws SQLException {
        accountDAO.update(accountEntity);
    }

    public void deleteAccount(int accountId) {
        accountDAO.delete(accountId);
    }
}


