package bankdao.interfaces;

import bankdao.entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {

    List<Account> getAllAccount();
    Account getAccountById(int id);
        void save(Account accountEntity);
        void update(Account accountEntity) throws SQLException;
        void delete(int accountId);
    }

