package bankdao.interfaces;

import bankdao.model.Account;
import bankdao.model.AccountHolderTransaction;
import bankdao.model.AccountTransaction;

import java.util.List;

public interface AccountHolderTransactionDAO {
    List<AccountHolderTransaction> getAllAccountHolderTransaction();
    AccountHolderTransaction getAccountHolderTransactionById(int id);
    void save(AccountHolderTransaction accountHolderTransaction);
    void update(AccountHolderTransaction accountHolderTransaction);
    void delete(AccountHolderTransaction accountHolderTransaction);
}
