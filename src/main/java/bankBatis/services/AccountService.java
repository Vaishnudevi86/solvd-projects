package bankBatis.services;
import bankBatis.main.MyBatisUtil;
import bankBatis.mappers.AccountMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import bankdao.entity.Account;

import java.util.List;

public class AccountService {

    Logger logger = LogManager.getLogger(AccountService.class.getName());

    public Account selectAccountByAccountId(int accountId) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            return accountMapper.selectAccountByAccountId(accountId);
        }
    }

    public List<Account> getAllAccounts() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            return accountMapper.getAllAccounts();
        }
    }

    public void createAccount(Account account) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        AccountMapper accountMapper = session.getMapper(AccountMapper.class);
        accountMapper.createAccount(account);
        logger.info("Account number: " + account.getAccount_id() + " -> Insert account successfully");
        session.close();
    }

    public void updateAccount(Account account) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        AccountMapper accountMapper = session.getMapper(AccountMapper.class);
        accountMapper.updateAccount(account);
        logger.info("Account number: " + account.getAccount_id() + " -> Updated successfully!");
        session.close();
    }

    public void deleteAccountByAccountId(int accountId) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession(true);
        AccountMapper accountMapper = session.getMapper(AccountMapper.class);
        accountMapper.deleteAccountByAccountId(accountId);
        logger.info("Account Id: " + accountId + " -> Deleted successfully!");
        session.close();
    }
}