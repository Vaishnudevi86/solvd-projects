package bankBatis.services;

import bankBatis.main.MyBatisUtil;
import bankBatis.mappers.SavingsAccountMapper;
import bankdao.entity.SavingsAccount;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SavingsAccountService {
    private final SqlSessionFactory sqlSessionFactory;

    public SavingsAccountService() {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    public SavingsAccount getSavingsAccountById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SavingsAccountMapper savingsAccountMapper = session.getMapper(SavingsAccountMapper.class);
            return savingsAccountMapper.selectSavingsAccountById(id);
        }
    }

    public List<SavingsAccount> getAllSavingsAccounts() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            SavingsAccountMapper savingsAccountMapper = session.getMapper(SavingsAccountMapper.class);
            return savingsAccountMapper.selectSavingsAccountsByCustomerId();
        }
    }

    public void addSavingsAccount(SavingsAccount savingsAccount) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            SavingsAccountMapper savingsAccountMapper = session.getMapper(SavingsAccountMapper.class);
            savingsAccountMapper.insertSavingsAccount(savingsAccount);
        }
    }

    public void updateSavingsAccount(SavingsAccount savingsAccount) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            SavingsAccountMapper savingsAccountMapper = session.getMapper(SavingsAccountMapper.class);
            savingsAccountMapper.updateSavingsAccount(savingsAccount);
        }
    }

    public void deleteSavingsAccount(int id) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            SavingsAccountMapper savingsAccountMapper = session.getMapper(SavingsAccountMapper.class);
            savingsAccountMapper.deleteSavingsAccount(id);
        }
    }
}