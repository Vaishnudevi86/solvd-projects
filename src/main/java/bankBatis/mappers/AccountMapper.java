package bankBatis.mappers;

import bankdao.entity.Account;
import java.util.List;

public interface AccountMapper {
    Account selectAccountByAccountId(int accountId);
    void createAccount(Account account);
    void updateAccount(Account account);
    void deleteAccountByAccountId(int accountId);
    List<Account> getAllAccounts();
}