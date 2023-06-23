package bankBatis.services;

import bankBatis.main.MyBatisUtil;
import bankBatis.mappers.CreditAccountMapper;
import bankdao.entity.CreditAccount;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CreditAccountService {
    private final SqlSessionFactory sqlSessionFactory;

    public CreditAccountService() {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    public CreditAccount getCreditAccountById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CreditAccountMapper creditAccountMapper = session.getMapper(CreditAccountMapper.class);
            return creditAccountMapper.selectCreditAccountById(id);
        }
    }

    public List<CreditAccount> getAllCreditAccounts() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CreditAccountMapper creditAccountMapper = session.getMapper(CreditAccountMapper.class);
            return creditAccountMapper.selectCreditAccountsByCustomerId();
        }
    }

    public void addCreditAccount(CreditAccount creditAccount) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            CreditAccountMapper creditAccountMapper = session.getMapper(CreditAccountMapper.class);
            creditAccountMapper.insertCreditAccount(creditAccount);
        }
    }

    public void updateCreditAccount(CreditAccount creditAccount) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            CreditAccountMapper creditAccountMapper = session.getMapper(CreditAccountMapper.class);
            creditAccountMapper.updateCreditAccount(creditAccount);
        }
    }

    public void deleteCreditAccount(int id) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            CreditAccountMapper creditAccountMapper = session.getMapper(CreditAccountMapper.class);
            creditAccountMapper.deleteCreditAccount(id);
        }
    }
}