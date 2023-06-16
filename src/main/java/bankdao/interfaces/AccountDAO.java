package bankdao.interfaces;

import bankdao.entity.AccountEntity;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {

    List<AccountEntity> getAllAccount();
    AccountEntity getAccountById(int id);
        void save(AccountEntity accountEntity);
        void update(AccountEntity accountEntity) throws SQLException;
        void delete(int accountId);
    }

