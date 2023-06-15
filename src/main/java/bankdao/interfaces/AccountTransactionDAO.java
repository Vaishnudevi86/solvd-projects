package bankdao.interfaces;

import bankdao.model.Account;
import bankdao.model.AccountTransaction;

import java.util.List;

public interface AccountTransactionDAO {
    List<AccountTransaction> getAllAccountTransaction();
    AccountTransaction getAccountTransactionById(int id);
    void save(AccountTransaction accountTransaction);
    void update(AccountTransaction accountTransaction);
    void delete(AccountTransaction accountTransaction);
}
