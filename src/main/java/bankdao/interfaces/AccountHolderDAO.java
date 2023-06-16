package bankdao.interfaces;

import bankdao.entity.AccountHolder;

import java.util.List;

public interface AccountHolderDAO {
    List<AccountHolder> getAllAccountHolder();
    AccountHolder getAccountHolderById(int id);
    void save(AccountHolder accountHolder);
    void update(AccountHolder accountHolder);
    void delete(AccountHolder accountHolder);
}
