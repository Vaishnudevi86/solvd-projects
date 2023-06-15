package bankdao.interfaces;

import bankdao.model.Account;
import bankdao.model.AccountHolder;
import bankdao.model.AccountHolderTransaction;

import java.util.List;

public interface AccountDAO {

    List<Account> getAllAccount();
    Account getAccountById(int id);
        void save(Account account);
        void update(Account account);
        void delete(Account account);
    }

