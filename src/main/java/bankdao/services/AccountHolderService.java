package bankdao.services;

import bankdao.interfaces.AccountHolderDAO;
import bankdao.model.AccountHolder;

import java.util.List;

public class AccountHolderService {
    private AccountHolderDAO accountHolderDAO;

    public AccountHolderService(AccountHolderDAO accountHolderDao) {
        this.accountHolderDAO = accountHolderDao ;
    }

    public AccountHolder getAccountHolderById(int id) {
        return accountHolderDAO.getAccountHolderById(id);
    }

    public List<AccountHolder> getAllAccountHolder() {
        return accountHolderDAO.getAllAccountHolder();
    }

    public void saveAccountHolder(AccountHolder accountHolder) {
        accountHolderDAO.save(accountHolder);
    }

    public void updateAccountHolder(AccountHolder accountHolder) {
        accountHolderDAO.update(accountHolder);
    }

    public void deleteAccountHolder(AccountHolder accountHolder) {
        accountHolderDAO.delete(accountHolder);
    }
}
